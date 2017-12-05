package com.kalix.research.person.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Administrator on 2017/3/3.
 */
@Entity
@Table(name = "research_person_teacher")
@ApiModel("教师<br>TeacherBean")
public class TeacherBean extends PersistentEntity {
    @ApiModelProperty(value = "用户id", position = 0, example = "1")
    private Long userId;
    @ApiModelProperty(value = "姓名", position = 1, example = "陈某")
    private String name;
    @ApiModelProperty(value = "身份证号", position = 2, example = "220***************")
    private String identificationCard;
    @ApiModelProperty(value = "性别（男 女）", allowableValues = "男,女", position = 3, example = "男")
    private String sex;
    @ApiModelProperty(value = "手机", position = 4, example = "18866667777")
    private String mobile;
    @ApiModelProperty(value = "所在单位id", position = 5, example = "0")
    private Long orgId;
    @Transient
    private String orgName;
    @ApiModelProperty(value = "职称", position = 6, example = "高级教师")
    private Long positionalTitles;
    @ApiModelProperty(value = "个人简历", position = 7, example = "0")
    private String resume;
    @ApiModelProperty(value = "个人说明", position = 8, example = "0")
    private String introduction;
    @ApiModelProperty(value = "学术研究", position = 9, example = "0")
    private String learning;
    @ApiModelProperty(value = "教学情况", position = 10, example = "0")
    private String teaching;
    @ApiModelProperty(value = "擅长课程", position = 11, example = "0")
    private String coursesSkills;
    @ApiModelProperty(value = "预备知识", position = 12, example = "0")
    private String preliminary;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Long getPositionalTitles() {
        return positionalTitles;
    }

    public void setPositionalTitles(Long positionalTitles) {
        this.positionalTitles = positionalTitles;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLearning() {
        return learning;
    }

    public void setLearning(String learning) {
        this.learning = learning;
    }

    public String getTeaching() {
        return teaching;
    }

    public void setTeaching(String teaching) {
        this.teaching = teaching;
    }

    public String getCoursesSkills() {
        return coursesSkills;
    }

    public void setCoursesSkills(String coursesSkills) {
        this.coursesSkills = coursesSkills;
    }

    public String getPreliminary() {
        return preliminary;
    }

    public void setPreliminary(String preliminary) {
        this.preliminary = preliminary;
    }
}
