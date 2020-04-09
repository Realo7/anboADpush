package com.hq.adpush.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Advertisement {
    //id
    private Integer ID;
    //
    private String AdvertID;
    //
    private String name;
    //
    private String regType;
    //
    private String cityId;
    //
    private String accountType;
    //
    private String contactName;
    //
    private String contactMobile;
    //
    private String source;
    //
    private String manager;
    //
    private String accountName;
    //
    private String bankName;
    //
    private String accountNo;
    //
    private String password;
    //
    private String publicKey;
    //
    private String sign;
    //
    private String partnerId;
    //
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date CTime;
    //
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date MTime;
    //
    private String Extend1;
    //
    private String Extend2;
    //
    private String Extend3;
    //
    private Integer Status;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAdvertID() {
        return AdvertID;
    }

    public void setAdvertID(String advertID) {
        AdvertID = advertID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public Date getCTime() {
        return CTime;
    }

    public void setCTime(Date CTime) {
        this.CTime = CTime;
    }

    public Date getMTime() {
        return MTime;
    }

    public void setMTime(Date MTime) {
        this.MTime = MTime;
    }

    public String getExtend1() {
        return Extend1;
    }

    public void setExtend1(String extend1) {
        Extend1 = extend1;
    }

    public String getExtend2() {
        return Extend2;
    }

    public void setExtend2(String extend2) {
        Extend2 = extend2;
    }

    public String getExtend3() {
        return Extend3;
    }

    public void setExtend3(String extend3) {
        Extend3 = extend3;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "ID=" + ID +
                ", AdvertID='" + AdvertID + '\'' +
                ", name='" + name + '\'' +
                ", regType='" + regType + '\'' +
                ", cityId='" + cityId + '\'' +
                ", accountType='" + accountType + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactMobile='" + contactMobile + '\'' +
                ", source='" + source + '\'' +
                ", manager='" + manager + '\'' +
                ", accountName='" + accountName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", password='" + password + '\'' +
                ", publicKey='" + publicKey + '\'' +
                ", sign='" + sign + '\'' +
                ", partnerId='" + partnerId + '\'' +
                ", CTime=" + CTime +
                ", MTime=" + MTime +
                ", Extend1='" + Extend1 + '\'' +
                ", Extend2='" + Extend2 + '\'' +
                ", Extend3='" + Extend3 + '\'' +
                ", Status=" + Status +
                '}';
    }
}
