package com.kalix.research.person.biz;

import com.kalix.admin.core.api.biz.IOrganizationBeanService;
import com.kalix.admin.core.api.biz.IUserBeanService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.web.model.QueryDTO;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.Assert;
import com.kalix.research.person.api.dao.IStudentBeanDao;
import com.kalix.research.person.api.biz.IStudentBeanService;
import com.kalix.research.person.entities.StudentBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fj on 2017-8-17.
 */
public class StudentBeanServiceImpl extends ShiroGenericBizServiceImpl<IStudentBeanDao, StudentBean> implements IStudentBeanService {
    private static final String FUNCTION_NAME = "学生信息";
    private IUserBeanService userBeanService;
    private IOrganizationBeanService organizationBeanService;

    public StudentBeanServiceImpl() {
        super.init(StudentBean.class.getName());
    }

    @Override
    public boolean isSave(StudentBean entity, JsonStatus status) {
        StudentBean bean = (StudentBean) entity;
        List<StudentBean> studentBeans = dao.find("select ob from StudentBean ob where ob.userId = ?1", bean.getUserId());
        if (studentBeans != null && studentBeans.size() > 0) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isUpdate(StudentBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        StudentBean bean = (StudentBean) entity;
        List<StudentBean> studentBeens = dao.find("select ob from StudentBean ob where ob.id <> ?1 and ob.userId = ?2",
                bean.getId(), bean.getUserId());
        if (studentBeens != null && studentBeens.size() > 0) {
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

    /*@Override
    public StudentBean getEntity(long entityId) {
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("userId/name/name", userBeanService);
        maps.put("majorId/majorName/name", organizationBeanService);
        return super.getEntity(entityId, maps);
    }*/

    /*@Override
    public JsonData getAllEntityByQuery(QueryDTO queryDTO) {
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("userId/name/name", userBeanService);
        maps.put("classId/className/name", organizationBeanService);
        return super.getAllEntityByQuery(queryDTO, maps);
    }*/

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        return dao.getAllRelations(page, limit, jsonStr, sort);
    }

    public void setUserBeanService(IUserBeanService userBeanService) {
        this.userBeanService = userBeanService;
    }

    public void setOrganizationBeanService(IOrganizationBeanService organizationBeanService) {
        this.organizationBeanService = organizationBeanService;
    }
}
