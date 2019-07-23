package com.liang.gmall.beans;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class UmsMember implements Serializable {

    @Id
    private String id;
    private String memberLevelId;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private String status;
    private Date createTime;
    private String icon;
    private String gender;
    private Date birthday;
    private String city;
    private String job;
    private String personalizedSignature;
    private String sourceUid;
    private String sourceType;
    private String integration;
    private String growth;
    private String luckeyCount;
    private String accessToken;
    private String accessCode;
    private String historyIntegration;

    public UmsMember() {
    }

    public UmsMember(String id, String memberLevelId, String username, String password,
                     String nickname, String phone, String status, Date createTime, String icon,
                     String gender, Date birthday, String city, String job, String personalizedSignature,
                     String sourceUid, String sourceType, String integration, String growth, String luckeyCount,
                     String accessToken, String accessCode, String historyIntegration) {
        this.id = id;
        this.memberLevelId = memberLevelId;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.status = status;
        this.createTime = createTime;
        this.icon = icon;
        this.gender = gender;
        this.birthday = birthday;
        this.city = city;
        this.job = job;
        this.personalizedSignature = personalizedSignature;
        this.sourceUid = sourceUid;
        this.sourceType = sourceType;
        this.integration = integration;
        this.growth = growth;
        this.luckeyCount = luckeyCount;
        this.accessToken = accessToken;
        this.accessCode = accessCode;
        this.historyIntegration = historyIntegration;
    }

    @Override
    public String toString() {
        return "UmsMember{" +
                "id='" + id + '\'' +
                ", memberLevelId='" + memberLevelId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", icon='" + icon + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", city='" + city + '\'' +
                ", job='" + job + '\'' +
                ", personalizedSignature='" + personalizedSignature + '\'' +
                ", sourceUid='" + sourceUid + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", integration='" + integration + '\'' +
                ", growth='" + growth + '\'' +
                ", luckeyCount='" + luckeyCount + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", accessCode='" + accessCode + '\'' +
                ", historyIntegration='" + historyIntegration + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(String memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature;
    }

    public String getSourceUid() {
        return sourceUid;
    }

    public void setSourceUid(String sourceUid) {
        this.sourceUid = sourceUid;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getIntegration() {
        return integration;
    }

    public void setIntegration(String integration) {
        this.integration = integration;
    }

    public String getGrowth() {
        return growth;
    }

    public void setGrowth(String growth) {
        this.growth = growth;
    }

    public String getLuckeyCount() {
        return luckeyCount;
    }

    public void setLuckeyCount(String luckeyCount) {
        this.luckeyCount = luckeyCount;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getHistoryIntegration() {
        return historyIntegration;
    }

    public void setHistoryIntegration(String historyIntegration) {
        this.historyIntegration = historyIntegration;
    }
}