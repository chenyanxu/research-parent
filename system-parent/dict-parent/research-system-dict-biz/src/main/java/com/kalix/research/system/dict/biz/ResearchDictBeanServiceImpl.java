package com.kalix.research.system.dict.biz;

import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.system.BaseDictServiceImpl;
import com.kalix.research.system.dict.api.biz.IResearchDictBeanService;
import com.kalix.research.system.dict.api.dao.IResearchDictBeanDao;
import com.kalix.research.system.dict.entities.ResearchDictBean;

public class ResearchDictBeanServiceImpl extends BaseDictServiceImpl<IResearchDictBeanDao, ResearchDictBean> implements IResearchDictBeanService {
    @Override
    public JsonStatus saveEntity(ResearchDictBean entity) {
        Integer maxValue = dao.getFieldMaxValue("value","type='"+entity.getType()+"'");

        maxValue=maxValue+1;

        entity.setValue(maxValue);

        return super.saveEntity(entity);
    }
}
