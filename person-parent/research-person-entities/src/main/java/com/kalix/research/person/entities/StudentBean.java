package com.kalix.research.person.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.persistence.PersistentEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/3.
 */
@Entity
@Table(name = "research_person_student")
@ApiModel("学生<br>StudentBean")
public class StudentBean extends PersistentEntity {
    @ApiModelProperty(value = "用户id", example = "1")
    @Column(unique = true)
    private Long userId;      //与用户关联id
    @Transient
    private String code;   //学号
    @Transient
    private String name;   //姓名
    @Transient
    private String sex;    //性别
    @Transient
    private String email;  //邮箱
    @Transient
    private String phone;  //固定电话
    @Transient
    private String mobile; //手机
    /*@ApiModelProperty(value="学院", position = 5, example = "软件学院")
    private String college;*/
    @ApiModelProperty(value = "专业id", example = "1")
    private Long majorId;
    @Transient
    private String majorName; //专业名称
    /*@ApiModelProperty(value = "班级id", position = 3, example = "000000000")
    private Long classId;
    @Transient
    private String className;*/
    @ApiModelProperty(value = "辅导员", example = "王老师")
    private String instructor;
    @ApiModelProperty(value = "身份证号", example = "220***************")
    private String identificationCard;
    @ApiModelProperty(value = "出生日期", example = "2010-02-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;
    @ApiModelProperty(value = "民族", example = "汉族")
    private String nation;
    @ApiModelProperty(value = "籍贯", example = "吉林省")
    private String placeOfOrigin;
    @ApiModelProperty(value = "政治面貌", example = "中共党员")
    private String politicalStatus;
    @ApiModelProperty(value = "入党团时间", example = "2010-02-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date joinPartyDate;
    @ApiModelProperty(value = "联系地址", example = "吉林省长春市")
    private String address;
    @ApiModelProperty(value = "邮政编码", example = "130000")
    private String postalcode;
    @ApiModelProperty(value = "家庭联系电话", example = "18866667777")
    private String homePhone;
    @ApiModelProperty(value = "生源省份", example = "吉林省")
    private Integer province; //字典[省份]
    @ApiModelProperty(value = "入学年份", example = "2017")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy", timezone = "GMT+8")
    private Date entranceYear;
    @ApiModelProperty(value = "学生培养层次", example = "本科")
    private String trainingLevel;
    @ApiModelProperty(value = "学习年限", example = "4")
    private String period;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
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

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Date getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(Date entranceYear) {
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
