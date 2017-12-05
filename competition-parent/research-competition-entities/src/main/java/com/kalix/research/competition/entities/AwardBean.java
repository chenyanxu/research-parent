package com.kalix.research.competition.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.persistence.PersistentEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/3.
 */
@Entity
@Table(name = "research_award")
@ApiModel("获奖信息<br>AwardBean")
public class AwardBean extends PersistentEntity {
    @ApiModelProperty(value = "展赛id", position = 0, example = "30002")
    private Long competitionId;
    @Transient
    private String competitionName;
    @ApiModelProperty(value = "展赛类别", position = 1, example = "动画类")
    private Integer competitionType;
    @ApiModelProperty(value = "报名id", position = 2, example = "10002")
    private Long signupId;
    @Transient
    private Long signupName;
    @ApiModelProperty(value = "获奖人", position = 3, example = "10002")
    private String awardName;
    @ApiModelProperty(value = "获奖级别", position = 4, example = "三等奖")
    private String awardLevel;
    @ApiModelProperty(value = "备注", position =5, example = "备注")
    @Lob
    private String remark;

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public Integer getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(Integer competitionType) {
        this.competitionType = competitionType;
    }

    public Long getSignupId() {
        return signupId;
    }

    public void setSignupId(Long signupId) {
        this.signupId = signupId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
