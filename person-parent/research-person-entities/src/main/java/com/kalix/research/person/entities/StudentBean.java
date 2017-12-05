package com.kalix.research.person.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by Administrator on 2017/3/3.
 */
@Entity
@Table(name = "research_person_student")
@ApiModel("学生<br>StudentBean")
public class StudentBean extends PersistentEntity {
    @ApiModelProperty(value = "用户id", position = 0, example = "1")
    private Long userId;
    @ApiModelProperty(value = "姓名", position = 1, example = "陈某")
    private String name;
    @ApiModelProperty(value = "学号", position = 2, example = "8000110007")
    private String studentNo;
    @ApiModelProperty(value = "班级id", position = 3, example = "000000000")
    private Long classId;
    @Transient
    private String className;
    /*@ApiModelProperty(value="专业", position = 4, example = "计算机")
    private String major;
    @ApiModelProperty(value="学院", position = 5, example = "软件学院")
    private String college;*/
    @ApiModelProperty(value = "辅导员", position = 6, example = "王老师")
    private String instructor;
    @ApiModelProperty(value = "性别（男 女）", allowableValues = "男,女", position = 7, example = "男")
    private String sex;
    @ApiModelProperty(value = "身份证号", position = 8, example = "220***************")
    private String identificationCard;
    @ApiModelProperty(value = "出生日期", position = 9, example = "2010-02-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;
    @ApiModelProperty(value = "民族", position = 10, example = "汉族")
    private String nation;
    @ApiModelProperty(value = "籍贯", position = 11, example = "吉林省")
    private String placeOfOrigin;
    @ApiModelProperty(value = "政治面貌", position = 12, example = "中共党员")
    private String politicalStatus;
    @ApiModelProperty(value = "入党团时间", position = 13, example = "2010-02-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date joinPartyDate;
    @ApiModelProperty(value = "联系地址", position = 14, example = "吉林省长春市")
    private String address;
    @ApiModelProperty(value = "邮政编码", position = 15, example = "130000")
    private String postalcode;
    @ApiModelProperty(value = "家庭联系电话", position = 16, example = "18866667777")
    private String homePhone;
    @ApiModelProperty(value = "生源省份", position = 17, example = "吉林省")
    private String province;
    @ApiModelProperty(value = "入学年份", position = 18, example = "2017")
    private String entranceYear;
    @ApiModelProperty(value = "学生培养层次", position = 19, example = "本科")
    private String trainingLevel;
    @ApiModelProperty(value = "学习年限", position = 20, example = "4")
    private String period;

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

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
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

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public Date getJoinPartyDate() {
        return joinPartyDate;
    }

    public void setJoinPartyDate(Date joinPartyDate) {
        this.joinPartyDate = joinPartyDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(String entranceYear) {
        this.entranceYear = entranceYear;
    }

    public String getTrainingLevel() {
        return trainingLevel;
    }

    public void setTrainingLevel(String trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
