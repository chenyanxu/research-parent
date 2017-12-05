package com.kalix.research.person.biz;

import com.kalix.admin.core.api.biz.IOrganizationBeanService;
import com.kalix.admin.core.api.biz.IUserBeanService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.web.model.QueryDTO;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.Assert;
import com.kalix.research.person.api.biz.IWorkerBeanService;
import com.kalix.research.person.api.dao.IWorkerBeanDao;
import com.kalix.research.person.entities.WorkerBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hqj on 2017-3-7.
 */
public class WorkerBeanServiceImpl extends ShiroGenericBizServiceImpl<IWorkerBeanDao, WorkerBean> implements IWorkerBeanService {
    private static final String FUNCTION_NAME = "科研人员信息";
    private IUserBeanService userBeanService;
    private IOrganizationBeanService organizationBeanService;

    public WorkerBeanServiceImpl() {
        super.init(WorkerBean.class.getName());
    }

    @Override
    public boolean isSave(WorkerBean entity, JsonStatus status) {
        WorkerBean bean = (WorkerBean) entity;
        List<WorkerBean> workerBeans = dao.find("select ob from WorkerBean ob where ob.userId = ?1", bean.getUserId());
        if (workerBeans != null && workerBeans.size() > 0) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isUpdate(WorkerBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        WorkerBean bean = (WorkerBean) entity;
        List<WorkerBean> workerBeans = dao.find("select ob from WorkerBean ob where ob.id <> ?1 and ob.userId = ?2",
                bean.getId(), bean.getUserId());
        if (workerBeans != null && workerBeans.size() > 0) {
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
    public WorkerBean getEntity(long entityId) {
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("userId/name/name", userBeanService);
        maps.put("orgId/orgName/name", organizationBeanService);
        return super.getEntity(entityId, maps);
    }

    @Override
    public JsonData getAllEntityByQuery(QueryDTO queryDTO) {
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("userId/name/name", userBeanService);
        maps.put("orgId/orgName/name", organizationBeanService);
        return super.getAllEntityByQuery(queryDTO, maps);
    }

    public void setUserBeanService(IUserBeanService userBeanService) {
        this.userBeanService = userBeanService;
    }

    public void setOrganizationBeanService(IOrganizationBeanService organizationBeanService) {
        this.organizationBeanService = organizationBeanService;
    }
}
