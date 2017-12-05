package com.kalix.research.competition.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.research.competition.entities.CompetitionInfoBean;

/**
 * Created by dell on 14-1-17.
 */
public interface ICompetitionInfoBeanService extends IBizService<CompetitionInfoBean> {
    JsonData getStatistics(Integer page, Integer limit, String jsonStr, String sort);
}
