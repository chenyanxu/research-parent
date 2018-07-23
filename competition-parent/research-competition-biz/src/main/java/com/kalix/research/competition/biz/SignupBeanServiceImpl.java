package com.kalix.research.competition.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.web.model.QueryDTO;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.research.competition.api.biz.ICompetitionInfoBeanService;
import com.kalix.research.competition.api.biz.ISignupBeanService;
import com.kalix.research.competition.api.dao.ISignupBeanDao;
import com.kalix.research.competition.entities.SignupBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fj on 2017-8-17.
 */
public class SignupBeanServiceImpl extends ShiroGenericBizServiceImpl<ISignupBeanDao, SignupBean> implements ISignupBeanService {
    private static final String FUNCTION_NAME = "展赛报名信息";
    private ICompetitionInfoBeanService competitionInfoBeanService;

    public SignupBeanServiceImpl() {
        super.init(SignupBean.class.getName());
    }

    /**
     * 报名信息统计
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
    public SignupBean getEntity(long entityId) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("competitionId/competitionName/name", competitionInfoBeanService);
        return super.getEntity(entityId, maps);
    }

    @Override
    public JsonData getAllEntityByQuery(QueryDTO queryDTO) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("competitionId/competitionName/name", competitionInfoBeanService);
        return super.getAllEntityByQuery(queryDTO, maps);
    }

    public void setCompetitionInfoBeanService(ICompetitionInfoBeanService competitionInfoBeanService) {
        this.competitionInfoBeanService = competitionInfoBeanService;
    }
}
