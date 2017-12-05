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

import java.util.*;

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
    public JsonData getStatistics(Integer page, Integer limit, String jsonStr, String sort){
        Map<String, String> jsonMap = SerializeUtil.json2Map(jsonStr);
        //jsonMap.put("userId", String.valueOf(this.getShiroService().getCurrentUserId()));

        return super.getAllEntityByQuery(page, limit, SerializeUtil.serializeJson(jsonMap), sort);
    }

    @Override
    public AwardBean getEntity(long entityId) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("competitionId/competitionName/name", competitionInfoBeanService);
        maps.put("signupId/signupName/name", signupBeanService);
        return super.getEntity(entityId, maps);
    }

    @Override
    public JsonData getAllEntityByQuery(QueryDTO queryDTO) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("competitionId/competitionName/name", competitionInfoBeanService);
        maps.put("signupId/signupName/name", signupBeanService);
        return super.getAllEntityByQuery(queryDTO, maps);
    }

    public void setCompetitionInfoBeanService(ICompetitionInfoBeanService competitionInfoBeanService) {
        this.competitionInfoBeanService = competitionInfoBeanService;
    }

    public void setSignupBeanService(ISignupBeanService signupBeanService) {
        this.signupBeanService = signupBeanService;
    }
}
