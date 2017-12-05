package com.kalix.research.competition.biz;

import com.kalix.admin.core.api.biz.IUserBeanService;
import com.kalix.admin.core.entities.UserBean;
import com.kalix.admin.template.api.biz.ITemplateBeanService;
import com.kalix.common.message.api.Const;
import com.kalix.common.message.api.MessageCategories;
import com.kalix.common.message.api.biz.IMessageBeanService;
import com.kalix.common.message.api.biz.ISenderMessageBeanService;
import com.kalix.common.message.entities.MessageBean;
import com.kalix.common.message.entities.SenderMessageBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.system.IDictBeanService;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.Assert;
import com.kalix.framework.core.util.JNDIHelper;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.middleware.mail.api.MailContent;
import com.kalix.middleware.mail.api.biz.IMailService;
import com.kalix.research.competition.api.biz.ICompetitionInfoBeanService;
import com.kalix.research.competition.api.dao.ICompetitionInfoBeanDao;
import com.kalix.research.competition.api.query.CompetitionChartDTO;
import com.kalix.research.competition.entities.CompetitionInfoBean;
import com.kalix.research.system.dict.entities.ResearchDictBean;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by fj on 2017-8-17.
 */
public class CompetitionInfoBeanServiceImpl extends ShiroGenericBizServiceImpl<ICompetitionInfoBeanDao, CompetitionInfoBean> implements ICompetitionInfoBeanService {
    private static final String FUNCTION_NAME = "展赛信息";
    //消息在stack保留的时间
    private static final int day = 24 * 60 * 60 * 1000;

    private IDictBeanService dictBeanService;
    private IUserBeanService userBeanService;
    private ITemplateBeanService templateBeanService;
    private ISenderMessageBeanService senderMessageBeanService;
    private IMessageBeanService messageBeanService;
    private IMailService mailService;
    private EventAdmin eventAdmin;

    public CompetitionInfoBeanServiceImpl() {
        super.init(CompetitionInfoBean.class.getName());
    }

    /**
     * 展赛信息统计
     *
     * @param page
     * @param limit
     * @param jsonStr
     * @return
     */
    @Override
    public JsonData getStatistics(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = new JsonData();
        String statisticsType = CompetitionStatistics.getStatisticsType(jsonStr);
        List<CompetitionChartDTO> tempList = null;

        if (statisticsType.equals("0")) {//按照时间段进行统计
            tempList = CompetitionStatistics.statisticsByBetweenDate(dao, jsonStr);
        } else if (statisticsType.equals("1")) {//按照月份进行统计
            tempList = CompetitionStatistics.statisticsByMonth(dao, jsonStr);
        } else if (statisticsType.equals("2")) {//按照季度进行统计
            tempList = CompetitionStatistics.statisticsByQuarter(dao, jsonStr);
        } else if (statisticsType.equals("3")) {//按照年进行统计
            tempList = CompetitionStatistics.statisticsByYear(dao, jsonStr);
        }

        jsonData.setTotalCount((long) tempList.size());
        jsonData.setData(tempList);

        return jsonData;
    }

    @Override
    public boolean isSave(CompetitionInfoBean entity, JsonStatus status) {
        CompetitionInfoBean bean = (CompetitionInfoBean) entity;
        List<CompetitionInfoBean> competitionInfoBeans = dao.find("select ob from CompetitionInfoBean ob where ob.name = ?1", bean.getName());
        if (competitionInfoBeans != null && competitionInfoBeans.size() > 0) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isUpdate(CompetitionInfoBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        CompetitionInfoBean bean = (CompetitionInfoBean) entity;
        List<CompetitionInfoBean> competitionInfoBeans = dao.find("select ob from CompetitionInfoBean ob where ob.id <> ?1 and ob.name = ?2",
                bean.getId(), bean.getName());
        if (competitionInfoBeans != null && competitionInfoBeans.size() > 0) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isDelete(Long entityId, JsonStatus status) {
        if (dao.get(entityId) == null) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经被删除！");
            return false;
        }
        return true;
    }

    @Override
    public void afterSaveEntity(CompetitionInfoBean entity, JsonStatus status) {
        CompetitionInfoBean bean = entity;
        // 发送消息
        // 组织消息内容
        String subject = "有关【" + bean.getName() + "】的参展参赛消息通知";
        String content = getMsgContentFromTemplate(bean);
        String content1 = content.replaceAll("<br>", "\n");

        // 获取用户信息
        List<UserBean> users = userBeanService.getAllEntity();

        // 发送内部系统消息(包括xmpp方式通过安装可配置,即发送吉林动画学院即时通软件)
        //sendMessageToCommonEvent(users, subject, content1);

        // 发送邮件(用户邮件)
        //sendMessageToUserEmail(users, subject, content);
    }

    private String getMsgContentFromTemplate(CompetitionInfoBean entity) {
        StringBuilder content = new StringBuilder();
        if (entity != null) {
            //content = templateBeanService.query("参展参赛系统消息发送模板").get(0).getContent();
            //TemplateBean templateBean = templateBeanService.getEntity(41201);
            //content = templateBean.getContent();
            content.append("展赛名称：" + entity.getName() + "<br>");
            String typeLabel = "";
            ResearchDictBean researchDictBean = (ResearchDictBean) dictBeanService.getByTypeAndValue("展赛类型", entity.getType());
            if (researchDictBean != null && researchDictBean.getLabel() != null) {
                typeLabel = researchDictBean.getLabel();
            }
            content.append("展赛类别：" + typeLabel + "<br>");
            content.append("展赛地点：" + (entity.getAddress() == null ? "" : entity.getAddress()) + "<br>");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            content.append("作品征集开始时间：" +
                    (entity.getCollectionStartTime() == null ? "" : dateFormat.format(entity.getCollectionStartTime())) + "<br>");
            content.append("作品征集结束时间：" +
                    (entity.getCollectionEndTime() == null ? "" : dateFormat.format(entity.getCollectionEndTime())) + "<br>");
            content.append("初评开始时间：" +
                    (entity.getPreEvalStartTime() == null ? "" : dateFormat.format(entity.getPreEvalStartTime())) + "<br>");
            content.append("初评结束时间：" +
                    (entity.getPreEvalEndTime() == null ? "" : dateFormat.format(entity.getPreEvalEndTime())) + "<br>");
            content.append("终评开始时间：" +
                    (entity.getLastEvalStartTime() == null ? "" : dateFormat.format(entity.getLastEvalStartTime())) + "<br>");
            content.append("终评结束时间：" +
                    (entity.getLastEvalEndTime() == null ? "" : dateFormat.format(entity.getLastEvalEndTime())) + "<br>");
            content.append("展览开始时间：" +
                    (entity.getCompStartTime() == null ? "" : dateFormat.format(entity.getCompStartTime())) + "<br>");
            content.append("展览结束时间：" +
                    (entity.getCompEndTime() == null ? "" : dateFormat.format(entity.getCompEndTime())) + "<br>");
            content.append("作品内容要求：" + (entity.getContentNeed() == null ? "" : entity.getContentNeed()) + "<br>");
            content.append("作品技术要求：" + (entity.getTechnologyNeed() == null ? "" : entity.getTechnologyNeed()) + "<br>");
            content.append("联系人：" + (entity.getContactor() == null ? "" : entity.getContactor()) + "<br>");
            content.append("联系人电话：" + (entity.getPhone() == null ? "" : entity.getPhone()) + "<br>");
            content.append("联系人邮箱：" + (entity.getEmail() == null ? "" : entity.getEmail()) + "<br>");
            content.append("详细信息：" + (entity.getDetail() == null ? "" : entity.getDetail()) + "<br>");
            content.append("备注：" + (entity.getRemark() == null ? "" : entity.getRemark()) + "<br>");
        }
        return content.toString();
    }

    /**
     * 发送内部系统消息(Redis)
     *
     * @param users
     * @param subject
     * @param content
     */
    private void sendMessageToCommonEvent(List<UserBean> users, String subject, String content) {
        String receiverIds = "";
        String receiverNames = "";
        int lpointer = 1;
        for (int i = 0; i < users.size(); i++) {
            UserBean user = users.get(i);
            if (user != null) {
                // 创建系统消息（个人消息模式）
                MessageBean senderMessage = createCommonMessage(user.getId(), subject, content);
                // 发送消息通知
                postCommonEvent(senderMessage);

                // 保存收件信息
                messageBeanService.saveEntity(senderMessage);

                // 保存发件信息
                if (receiverIds.equals("")) {
                    receiverIds = String.valueOf(user.getId());
                    receiverNames = user.getLoginName();
                } else {
                    receiverIds = receiverIds + "," + String.valueOf(user.getId());
                    receiverNames = receiverNames + "," + user.getLoginName();
                }
                if (lpointer >= 20) {
                    SenderMessageBean senderMessageBean = new SenderMessageBean();
                    senderMessageBean.setSenderId(shiroService.getCurrentUserId());
                    senderMessageBean.setReceiverIds(receiverIds);
                    senderMessageBean.setReceiverNames(receiverNames);
                    senderMessageBean.setCategory(String.valueOf(MessageCategories.COMMON.getId()));//0 系统消息,1 流程消息， 2 个人消息,3 计划任务消息
                    senderMessageBean.setTitle(subject);
                    senderMessageBean.setContent(content);
                    senderMessageBeanService.saveEntity(senderMessageBean);
                    lpointer = 0;
                    receiverIds = "";
                    receiverNames = "";
                }
                lpointer++;
            }
        }
        // 保存发件信息
        if (lpointer > 1 && !receiverIds.equals("")) {
            SenderMessageBean senderMessageBean = new SenderMessageBean();
            senderMessageBean.setSenderId(shiroService.getCurrentUserId());
            senderMessageBean.setReceiverIds(receiverIds);
            senderMessageBean.setReceiverNames(receiverNames);
            senderMessageBean.setCategory(String.valueOf(MessageCategories.COMMON.getId()));//0 系统消息,1 流程消息， 2 个人消息,3 计划任务消息
            senderMessageBean.setTitle(subject);
            senderMessageBean.setContent(content);
            senderMessageBeanService.saveEntity(senderMessageBean);
        }
    }

    /**
     * 创建需要发送的系统消息（采用个人消息模式）
     *
     * @param receiverId
     * @param title
     * @param content
     * @return
     */
    private MessageBean createCommonMessage(Long receiverId, String title, String content) {
        MessageBean messageBean = new MessageBean();
        messageBean.setCreationDate(new Date());
        messageBean.setSenderId(shiroService.getCurrentUserId());
        messageBean.setSenderName(shiroService.getCurrentUserRealName());
        messageBean.setReceiverId(receiverId);
        messageBean.setCategory(MessageCategories.COMMON.getId());//0 系统消息,1 流程消息， 2 个人消息,3 计划任务消息
        messageBean.setTitle(title);
        messageBean.setContent(content);
        messageBean.setRead(false);
        messageBean.setState(0);
        return messageBean;
    }

    /**
     * 发送消息通知
     *
     * @param msgBean
     */
    private void postCommonEvent(MessageBean msgBean) {
        try {
            eventAdmin = JNDIHelper.getJNDIServiceForName("org.osgi.service.event.EventAdmin");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Dictionary properties = new Hashtable();
        properties.put("userId", msgBean.getReceiverId());
        Event osgi_event = new Event(Const.COMMON_MESSAGE_TOPIC, properties);
        System.out.println("User name: " + msgBean.getReceiverId() + " message is sent!");
        eventAdmin.postEvent(osgi_event);
    }

    /**
     * 发送邮件(用户邮件)
     *
     * @param users
     * @param subject
     * @param content
     */
    private void sendMessageToUserEmail(List<UserBean> users, String subject, String content) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < users.size(); i++) {
            UserBean user = users.get(i);
            if (user != null) {
                String email = user.getEmail();
                if (email != null && !email.equals("")) {
                    map.put(user.getLoginName(), email);
                }
            }
        }
        if (map.size() > 0) {
            MailContent mailContent = new MailContent();
            mailContent.setSubject(subject);
            mailContent.setContent(content);
            mailContent.setReceivemail(map);
            mailService.sendMail(mailContent);
        }
    }

    public void setDictBeanService(IDictBeanService dictBeanService) {
        this.dictBeanService = dictBeanService;
    }

    public void setUserBeanService(IUserBeanService userBeanService) {
        this.userBeanService = userBeanService;
    }

    public void setTemplateBeanService(ITemplateBeanService templateBeanService) {
        this.templateBeanService = templateBeanService;
    }

    public void setSenderMessageBeanService(ISenderMessageBeanService senderMessageBeanService) {
        this.senderMessageBeanService = senderMessageBeanService;
    }

    public void setMessageBeanService(IMessageBeanService messageBeanService) {
        this.messageBeanService = messageBeanService;
    }

    public void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }
}
