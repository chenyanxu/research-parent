package com.kalix.research.system.dict.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.research.system.dict.api.dao.IResearchDictBeanDao;
import com.kalix.research.system.dict.entities.ResearchDictBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ResearchDictBeanDaoImpl extends GenericDao<ResearchDictBean, Long> implements IResearchDictBeanDao {
    @Override
    @PersistenceContext(unitName = "research-system-dict-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
