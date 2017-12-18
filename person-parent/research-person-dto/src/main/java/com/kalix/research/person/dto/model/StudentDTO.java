package com.kalix.research.person.dto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.web.model.BaseDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 学生信息模型类
 * @author hqj date:2017-12-15
 * @version 1.0.0
 */
public class StudentDTO extends BaseDTO {
    private Long userId;               //与用户关联id
    private String code;       //学号
    private String name;       //姓名
    private String sex;        //性别
    private String email;      //邮箱
    private String phone;      //固定电话
    private String mobile;     //手机
    private Long majorId;              //专业id
    private String majorName;          //专业名称
    private String instructor;         //辅导员
    private String identificationCard; //身份证号
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;             //出生日期
    private String nation;             //民族
    private String placeOfOrigin;      //籍贯
    private String politicalStatus;    //政治面貌
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date joinPartyDate;        //入党团时间
    private String address;            //联系地址
    private String postalcode;         //邮政编码
    private String homePhone;          //家庭联系电话
    private String province;           //生源省份
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy", timezone = "GMT+8")
    private Date entranceYear;       //入学年份
    private String trainingLevel;      //学生培养层次
    private String period;             //学习年限
    private Long version_;             //版本控制

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
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

    public Long getVersion_() {
        return version_;
    }

    public void setVersion_(Long version_) {
        this.version_ = version_;
    }
}
