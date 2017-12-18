package com.kalix.research.person.api.dao;

import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.research.person.entities.StudentBean;

/**
 * Created by Administrator on 2017/3/3.
 */
public interface IStudentBeanDao extends IGenericDao<StudentBean,Long> {
    JsonData getAllRelations(Integer page, Integer limit, String jsonStr, String sort);
}
