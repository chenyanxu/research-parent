package com.kalix.research.competition.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.persistence.PersistentEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/11.
 */
@Entity
@Table(name = "research_signup")
@ApiModel("报名信息<br>SignupBean")
public class SignupBean extends PersistentEntity {
    @ApiModelProperty(value = "展赛信息id", position = 0, example = "3330202")
    private Long competitionId;
    @Transient
    private String competitionName;
    @ApiModelProperty(value = "姓名", position = 1, example = "张三")
    private String name;
    @ApiModelProperty(value = "拼音", position = 2, example = "zhangsan")
    private String phoneticize;
    @ApiModelProperty(value = "性别", position = 3, example = "男")
    private String sex;
    @ApiModelProperty(value = "出生日期", position = 4, example = "2010-02-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;
    @ApiModelProperty(value = "国籍", position = 5, example = "中国")
    private String nationality;
    @ApiModelProperty(value = "身份证号", position = 6, example = "220521199010103")
    private String identificationCard;
    @ApiModelProperty(value = "省", position = 7, example = "吉林省")
    private String province;
    @ApiModelProperty(value = "城市", position = 8, example = "长春市")
    private String city;
    @ApiModelProperty(value = "笔名", position = 9, example = "笔名")
    private String penName;
    @ApiModelProperty(value = "作者简介", position = 10, example = "作者简介")
    @Lob
    private String authorIntroduction;
    @ApiModelProperty(value = "通讯地址", position = 11, example = "吉林省长春市朝阳区")
    private String postalAddress;
    @ApiModelProperty(value = "邮政编码", position = 12, example = "130000")
    private String postalCode;
    @ApiModelProperty(value = "移动电话", position = 13, example = "15123222323")
    private String mobilePhone;
    @ApiModelProperty(value = "固定电话", position = 14, example = "0431-3333443")
    private String fixedPhone;
    @ApiModelProperty(value = "电子邮箱", position = 15, example = "739854544@qq.com")
    private String email;
    @ApiModelProperty(value = "QQ", position = 16, example = "7434332")
    private String qq;
    @ApiModelProperty(value = "传真", position = 17, example = "334232")
    private String fax;
    @ApiModelProperty(value = "微博", position = 18, example = "weibo@sina.cn")
    private String microBlog;
    @ApiModelProperty(value = "其他联系方式", position = 19, example = "34333222")
    private String otherContactWay;
    @ApiModelProperty(value = "所在学校", position = 20, example = "动画学院")
    private String school;
    @ApiModelProperty(value = "专业/班级", position = 21, example = "动画设计101")
    private String majorClass;
    @ApiModelProperty(value = "网址", position = 22, example = "http://lujing")
    private String url;
    @ApiModelProperty(value = "团队中文名称", position = 23, example = "拼搏小队")
    private String teamCnName;
    @ApiModelProperty(value = "团队英文名称", position = 24, example = "fighting")
    private String teamEnName;
    @ApiModelProperty(value = "团队联系人", position = 25, example = "张三")
    private String teamContacter;
    @ApiModelProperty(value = "团队所在地", position = 26, example = "吉林省长春市动画学院")
    private String teamAddress;
    @ApiModelProperty(value = "作品中文名称", position = 27, example = "前进的蜗牛")
    private String worksCnName;
    @ApiModelProperty(value = "作品英文名称", position = 28, example = "going on")
    private String worksEnName;
    @ApiModelProperty(value = "作品介绍", position = 29, example = "作品介绍")
    @Lob
    private String worksIntroduction;
    @ApiModelProperty(value = "出品国家", position = 30, example = "中国")
    private String country;
    @ApiModelProperty(value = "获奖情况", position = 31, example = "7396333@qq.com")
    private String award;
    @ApiModelProperty(value = "播出情况", position = 32, example = "在播")
    private String broadcasting;
    @ApiModelProperty(value = "指导教师", position = 33, example = "张老师")
    private String tutor;
    @ApiModelProperty(value = "制作完成时间", position = 34, example = "2017-11-23")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date finishingDate;
    @ApiModelProperty(value = "作品时长", position = 35, example = "10分钟")
    private String lengthOfWork;
    @ApiModelProperty(value = "版权所有者", position = 36, example = "张三")
    private String copyrightOwner;
    @ApiModelProperty(value = "出品单位", position = 37, example = "动画学院")
    private String unit;
    @ApiModelProperty(value = "出品单位联系人", position = 38, example = "李老师")
    private String unitContacter;
    @ApiModelProperty(value = "主创人员", position = 39, example = "王老师")
    private String creator;

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneticize() {
        return phoneticize;
    }

    public void setPhoneticize(String phoneticize) {
        this.phoneticize = phoneticize;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

    public String getAuthorIntroduction() {
        return authorIntroduction;
    }

    public void setAuthorIntroduction(String authorIntroduction) {
        this.authorIntroduction = authorIntroduction;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getFixedPhone() {
        return fixedPhone;
    }

    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMicroBlog() {
        return microBlog;
    }

    public void setMicroBlog(String microBlog) {
        this.microBlog = microBlog;
    }

    public String getOtherContactWay() {
        return otherContactWay;
    }

    public void setOtherContactWay(String otherContactWay) {
        this.otherContactWay = otherContactWay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajorClass() {
        return majorClass;
    }

    public void setMajorClass(String majorClass) {
        this.majorClass = majorClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTeamCnName() {
        return teamCnName;
    }

    public void setTeamCnName(String teamCnName) {
        this.teamCnName = teamCnName;
    }

    public String getTeamEnName() {
        return teamEnName;
    }

    public void setTeamEnName(String teamEnName) {
        this.teamEnName = teamEnName;
    }

    public String getTeamContacter() {
        return teamContacter;
    }

    public void setTeamContacter(String teamContacter) {
        this.teamContacter = teamContacter;
    }

    public String getTeamAddress() {
        return teamAddress;
    }

    public void setTeamAddress(String teamAddress) {
        this.teamAddress = teamAddress;
    }

    public String getWorksCnName() {
        return worksCnName;
    }

    public void setWorksCnName(String worksCnName) {
        this.worksCnName = worksCnName;
    }

    public String getWorksEnName() {
        return worksEnName;
    }

    public void setWorksEnName(String worksEnName) {
        this.worksEnName = worksEnName;
    }

    public String getWorksIntroduction() {
        return worksIntroduction;
    }

    public void setWorksIntroduction(String worksIntroduction) {
        this.worksIntroduction = worksIntroduction;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getBroadcasting() {
        return broadcasting;
    }

    public void setBroadcasting(String broadcasting) {
        this.broadcasting = broadcasting;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public Date getFinishingDate() {
        return finishingDate;
    }

    public void setFinishingDate(Date finishingDate) {
        this.finishingDate = finishingDate;
    }

    public String getLengthOfWork() {
        return lengthOfWork;
    }

    public void setLengthOfWork(String lengthOfWork) {
        this.lengthOfWork = lengthOfWork;
    }

    public String getCopyrightOwner() {
        return copyrightOwner;
    }

    public void setCopyrightOwner(String copyrightOwner) {
        this.copyrightOwner = copyrightOwner;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitContacter() {
        return unitContacter;
    }

    public void setUnitContacter(String unitContacter) {
        this.unitContacter = unitContacter;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
