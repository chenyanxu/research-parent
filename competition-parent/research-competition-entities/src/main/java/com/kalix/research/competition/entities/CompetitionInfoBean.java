package com.kalix.research.competition.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.persistence.PersistentEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Lob;

/**
 * Created by Administrator on 2017/3/3.
 */
@Entity
@Table(name = "research_competition_info")
@ApiModel("展赛信息<br>CompetitionInfoBean")
public class CompetitionInfoBean extends PersistentEntity {
    @ApiModelProperty(value = "展赛名称", position = 0, example = "动画作品大赛")
    private String name;
    @ApiModelProperty(value = "展赛类别", position = 1, example = "1")
    private Integer type;
    @ApiModelProperty(value = "展赛地点", position = 2, example = "动画学院")
    private String address;
    @ApiModelProperty(value = "作品征集开始时间", position = 3, example = "2017-11-23 08:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date collectionStartTime;
    @ApiModelProperty(value = "作品征集结束时间", position = 4, example = "2017-11-23 08:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date collectionEndTime;
    @ApiModelProperty(value = "初评开始时间", position = 5, example = "2017-11-23 08:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date preEvalStartTime;
    @ApiModelProperty(value = "初评结束时间", position = 6, example = "2017-11-23 08:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date preEvalEndTime;
    @ApiModelProperty(value = "终评开始时间", position = 7, example = "2017-11-23 08:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastEvalStartTime;
    @ApiModelProperty(value = "终评结束时间", position = 8, example = "2017-11-23 08:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastEvalEndTime;
    @ApiModelProperty(value = "展览开始时间", position = 9, example = "2017-11-23 08:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date compStartTime;
    @ApiModelProperty(value = "展览结束时间", position = 10, example = "2017-11-23 08:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date compEndTime;
    @ApiModelProperty(value = "作品内容要求", position = 11, example = "要求")
    @Lob
    private String contentNeed;
    @ApiModelProperty(value = "作品技术要求", position = 12, example = "要求")
    @Lob
    private String technologyNeed;
    @ApiModelProperty(value = "联系人", position = 13, example = "张三")
    private String contactor;
    @ApiModelProperty(value = "联系人电话", position = 14, example = "15123222323")
    private String phone;
    @ApiModelProperty(value = "联系人邮箱", position = 15, example = "7396333@qq.com")
    private String email;
    @ApiModelProperty(value = "报名表样式", position = 16, example = "http://lujing")
    private String signupStyle;
    @ApiModelProperty(value = "详细信息", position = 17, example = "详细信息")
    @Lob
    private String detail;
    @ApiModelProperty(value = "备注", position = 18, example = "备注")
    @Lob
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCollectionStartTime() {
        return collectionStartTime;
    }

    public void setCollectionStartTime(Date collectionStartTime) {
        this.collectionStartTime = collectionStartTime;
    }

    public Date getCollectionEndTime() {
        return collectionEndTime;
    }

    public void setCollectionEndTime(Date collectionEndTime) {
        this.collectionEndTime = collectionEndTime;
    }

    public Date getPreEvalStartTime() {
        return preEvalStartTime;
    }

    public void setPreEvalStartTime(Date preEvalStartTime) {
        this.preEvalStartTime = preEvalStartTime;
    }

    public Date getPreEvalEndTime() {
        return preEvalEndTime;
    }

    public void setPreEvalEndTime(Date preEvalEndTime) {
        this.preEvalEndTime = preEvalEndTime;
    }

    public Date getLastEvalStartTime() {
        return lastEvalStartTime;
    }

    public void setLastEvalStartTime(Date lastEvalStartTime) {
        this.lastEvalStartTime = lastEvalStartTime;
    }

    public Date getLastEvalEndTime() {
        return lastEvalEndTime;
    }

    public void setLastEvalEndTime(Date lastEvalEndTime) {
        this.lastEvalEndTime = lastEvalEndTime;
    }

    public Date getCompStartTime() {
        return compStartTime;
    }

    public void setCompStartTime(Date compStartTime) {
        this.compStartTime = compStartTime;
    }

    public Date getCompEndTime() {
        return compEndTime;
    }

    public void setCompEndTime(Date compEndTime) {
        this.compEndTime = compEndTime;
    }

    public String getContentNeed() {
        return contentNeed;
    }

    public void setContentNeed(String contentNeed) {
        this.contentNeed = contentNeed;
    }

    public String getTechnologyNeed() {
        return technologyNeed;
    }

    public void setTechnologyNeed(String technologyNeed) {
        this.technologyNeed = technologyNeed;
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignupStyle() {
        return signupStyle;
    }

    public void setSignupStyle(String signupStyle) {
        this.signupStyle = signupStyle;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
