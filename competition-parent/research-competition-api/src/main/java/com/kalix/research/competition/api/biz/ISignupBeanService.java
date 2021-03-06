package com.kalix.research.competition.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.research.competition.entities.SignupBean;

/**
 * Created by dell on 14-1-17.
 */
public interface ISignupBeanService extends IBizService<SignupBean> {
    JsonData getStatistics(Integer page, Integer limit, String jsonStr, String sort);
}
