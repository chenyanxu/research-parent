package com.kalix.research.competition.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.web.model.QueryDTO;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.research.competition.api.biz.IAwardBeanService;
import com.kalix.research.competition.api.biz.ICompetitionInfoBeanService;
import com.kalix.research.competition.api.biz.ISignupBeanService;
import com.kalix.research.competition.api.dao.IAwardBeanDao;
import com.kalix.research.competition.entities.AwardBean;
import com.kalix.research.competition.entities.CompetitionInfoBean;

import java.util.Map;

/**
 * Created by fj on 2017-8-17.
 */
public class AwardBeanServiceImpl extends ShiroGenericBizServiceImpl<IAwardBeanDao, AwardBean> implements IAwardBeanService {
    private static final String FUNCTION_NAME = "获奖信息";
    private ICompetitionInfoBeanService competitionInfoBeanService;
    private ISignupBeanService signupBeanService;

    public AwardBeanServiceImpl() {
        super.init(AwardBean.class.getName());
    }

    /**
     * 获奖信息统计
     *
     * @param page
     * @param limit
     * @param jsonStr
     * @return
     */
    @Override
    public JsonData getStatistics(Integer page, Integer limit, String jsonStr, String sort) {
        Map<String, String> jsonMap = SerializeUtil.json2Map(jsonStr);
        //jsonMap.put("userId", String.valueOf(this.getShiroService().getCurrentUserId()));
        return super.getAllEntityByQuery(page, limit, SerializeUtil.serializeJson(jsonMap), sort);
    }

    @Override
    public AwardBean getEntity(long entityId) {
        AwardBean awardBean = super.getEntity(entityId);
        // 关联查询多字段赋值
        CompetitionInfoBean competitionInfoBean = competitionInfoBeanService.getEntity(awardBean.getCompetitionId());
        awardBean.setCompetitionName(competitionInfoBean.getName());
        awardBean.setCompetitionType(competitionInfoBean.getType());
        return awardBean;
    }

    @Override
    public JsonData getAllEntityByQuery(QueryDTO queryDTO) {
        JsonData jsonData = super.getAllEntityByQuery(queryDTO);
        // 关联查询多字段赋值
        for (int i = 0; i < jsonData.getData().size(); i++) {
            AwardBean awardBean = (AwardBean) jsonData.getData().get(i);
            CompetitionInfoBean competitionInfoBean = competitionInfoBeanService.getEntity(awardBean.getCompetitionId());
            ((AwardBean) jsonData.getData().get(i)).setCompetitionName(competitionInfoBean.getName());
            ((AwardBean) jsonData.getData().get(i)).setCompetitionType(competitionInfoBean.getType());
        }
        return jsonData;
    }

    public void setCompetitionInfoBeanService(ICompetitionInfoBeanService competitionInfoBeanService) {
        this.competitionInfoBeanService = competitionInfoBeanService;
    }

    public void setSignupBeanService(ISignupBeanService signupBeanService) {
        this.signupBeanService = signupBeanService;
    }
}
