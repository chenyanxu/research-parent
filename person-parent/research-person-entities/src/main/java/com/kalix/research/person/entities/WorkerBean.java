package com.kalix.research.person.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.persistence.PersistentEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/3.
 */
@Entity
@Table(name = "research_person_worker")
@ApiModel("科研人员<br>WorkerBean")
public class WorkerBean extends PersistentEntity {
    @ApiModelProperty(value = "用户id", position = 0, example = "1")
    private Long userId;
    @ApiModelProperty(value = "姓名", position = 1, example = "陈某")
    private String name;
    @ApiModelProperty(value = "身份证号", position = 2, example = "220***************")
    private String identificationCard;
    @ApiModelProperty(value = "性别（男 女）", allowableValues = "男,女", position = 3, example = "男")
    private String sex;
    @ApiModelProperty(value = "出生日期", position = 4, example = "2010-02-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;
    @ApiModelProperty(value = "民族", position = 5, example = "汉族")
    private String nation;
    @ApiModelProperty(value = "籍贯", position = 6, example = "吉林省长春市")
    private String placeOfOrigin;
    @ApiModelProperty(value = "联系电话", position = 7, example = "13704310431")
    private String phone;
    @ApiModelProperty(value = "电子邮件", position = 8, example = "xxxxxxxxxxx@qq.com")
    private String email;
    @ApiModelProperty(value = "所在单位部门id", position = 9, example = "001")
    private Long orgId;
    @Transient
    private String orgName;
    @ApiModelProperty(value = "最初职称", position = 10, example = "助教")
    private String firstTitle;
    @ApiModelProperty(value = "最初职称评定时间", position = 11, example = "2010-02-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date firstEvaluateDate;
    @ApiModelProperty(value = "最后职称", position = 12, example = "讲师")
    private String lastTitle;
    @ApiModelProperty(value = "最后职称评定时间", position = 13, example = "2015-02-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastEvaluateDate;
    @ApiModelProperty(value = "最后学历", position = 14, example = "大学本科")
    private String education;
    @ApiModelProperty(value = "最后学位", position = 15, example = "学士学位")
    private String degree;
    @ApiModelProperty(value = "毕业院校", position = 16, example = "xxxx大学")
    private String school;
    @ApiModelProperty(value = "研究方向", position = 17, example = "xxxx专业")
    private String direction;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getFirstTitle() {
        return firstTitle;
    }

    public void setFirstTitle(String firstTitle) {
        this.firstTitle = firstTitle;
    }

    public Date getFirstEvaluateDate() {
        return firstEvaluateDate;
    }

    public void setFirstEvaluateDate(Date firstEvaluateDate) {
        this.firstEvaluateDate = firstEvaluateDate;
    }

    public String getLastTitle() {
        return lastTitle;
    }

    public void setLastTitle(String lastTitle) {
        this.lastTitle = lastTitle;
    }

    public Date getLastEvaluateDate() {
        return lastEvaluateDate;
    }

    public void setLastEvaluateDate(Date lastEvaluateDate) {
        this.lastEvaluateDate = lastEvaluateDate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
