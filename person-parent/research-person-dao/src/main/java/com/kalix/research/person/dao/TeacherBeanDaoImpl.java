package com.kalix.research.person.dao;

import com.kalix.research.person.api.dao.ITeacherBeanDao;
import com.kalix.research.person.entities.TeacherBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Administrator on 2017/3/3.
 */
public class TeacherBeanDaoImpl extends BaseAdminDao<TeacherBean,Long> implements ITeacherBeanDao {
}
