package com.hq.adpush.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Parkinglot {
    private String ParkinglotID;
    private String ParkinglotName;
    private String Address;
    private String TEL;
    private String Mobile;
    private String URL;
    private String Longitude;
    private String Latitude;
    private Integer Status;
    private Integer Grade;
    //
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date CTime;
    //
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date MTime;

    private Integer TotalSpace;
    private Integer SurplusSpace;
    private String Account;
    private Integer Redpackets;
    private String Extend1;
    private String Extend2;
    private String Extend3;
    private String Extend4;
    private String Extend5;
    private String LocalServerIP;
    private String LocalServerPort;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date LastCommTime;
    private Integer HeartbeatInterval;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date UpDownTime;
    private Integer DataStatus;
    private String FeteDayID;
    private String RestDayID;
    private String Images;
    private Integer District;
    private Integer CityID;
    private Integer ProvinceID;
    private Integer FreeTime;
    private String StayTime;
    private Integer CustomerID;

    @Override
    public String toString() {
        return "Parkinglot{" +
                "ParkinglotID='" + ParkinglotID + '\'' +
                ", ParkinglotName='" + ParkinglotName + '\'' +
                ", Address='" + Address + '\'' +
                ", TEL='" + TEL + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", URL='" + URL + '\'' +
                ", Longitude='" + Longitude + '\'' +
                ", Latitude='" + Latitude + '\'' +
                ", Status=" + Status +
                ", Grade=" + Grade +
                ", CTime=" + CTime +
                ", MTime=" + MTime +
                ", TotalSpace=" + TotalSpace +
                ", SurplusSpace=" + SurplusSpace +
                ", Account='" + Account + '\'' +
                ", Redpackets=" + Redpackets +
                ", Extend1='" + Extend1 + '\'' +
                ", Extend2='" + Extend2 + '\'' +
                ", Extend3='" + Extend3 + '\'' +
                ", Extend4='" + Extend4 + '\'' +
                ", Extend5='" + Extend5 + '\'' +
                ", LocalServerIP='" + LocalServerIP + '\'' +
                ", LocalServerPort='" + LocalServerPort + '\'' +
                ", LastCommTime=" + LastCommTime +
                ", HeartbeatInterval=" + HeartbeatInterval +
                ", UpDownTime=" + UpDownTime +
                ", DataStatus=" + DataStatus +
                ", FeteDayID='" + FeteDayID + '\'' +
                ", RestDayID='" + RestDayID + '\'' +
                ", Images='" + Images + '\'' +
                ", District=" + District +
                ", CityID=" + CityID +
                ", ProvinceID=" + ProvinceID +
                ", FreeTime=" + FreeTime +
                ", StayTime='" + StayTime + '\'' +
                ", CustomerID=" + CustomerID +
                '}';
    }

    public String getParkinglotID() {
        return ParkinglotID;
    }

    public void setParkinglotID(String parkinglotID) {
        ParkinglotID = parkinglotID;
    }

    public String getParkinglotName() {
        return ParkinglotName;
    }

    public void setParkinglotName(String parkinglotName) {
        ParkinglotName = parkinglotName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public Integer getGrade() {
        return Grade;
    }

    public void setGrade(Integer grade) {
        Grade = grade;
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

    public Integer getTotalSpace() {
        return TotalSpace;
    }

    public void setTotalSpace(Integer totalSpace) {
        TotalSpace = totalSpace;
    }

    public Integer getSurplusSpace() {
        return SurplusSpace;
    }

    public void setSurplusSpace(Integer surplusSpace) {
        SurplusSpace = surplusSpace;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public Integer getRedpackets() {
        return Redpackets;
    }

    public void setRedpackets(Integer redpackets) {
        Redpackets = redpackets;
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

    public String getExtend4() {
        return Extend4;
    }

    public void setExtend4(String extend4) {
        Extend4 = extend4;
    }

    public String getExtend5() {
        return Extend5;
    }

    public void setExtend5(String extend5) {
        Extend5 = extend5;
    }

    public String getLocalServerIP() {
        return LocalServerIP;
    }

    public void setLocalServerIP(String localServerIP) {
        LocalServerIP = localServerIP;
    }

    public String getLocalServerPort() {
        return LocalServerPort;
    }

    public void setLocalServerPort(String localServerPort) {
        LocalServerPort = localServerPort;
    }

    public Date getLastCommTime() {
        return LastCommTime;
    }

    public void setLastCommTime(Date lastCommTime) {
        LastCommTime = lastCommTime;
    }

    public Integer getHeartbeatInterval() {
        return HeartbeatInterval;
    }

    public void setHeartbeatInterval(Integer heartbeatInterval) {
        HeartbeatInterval = heartbeatInterval;
    }

    public Date getUpDownTime() {
        return UpDownTime;
    }

    public void setUpDownTime(Date upDownTime) {
        UpDownTime = upDownTime;
    }

    public Integer getDataStatus() {
        return DataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        DataStatus = dataStatus;
    }

    public String getFeteDayID() {
        return FeteDayID;
    }

    public void setFeteDayID(String feteDayID) {
        FeteDayID = feteDayID;
    }

    public String getRestDayID() {
        return RestDayID;
    }

    public void setRestDayID(String restDayID) {
        RestDayID = restDayID;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }

    public Integer getDistrict() {
        return District;
    }

    public void setDistrict(Integer district) {
        District = district;
    }

    public Integer getCityID() {
        return CityID;
    }

    public void setCityID(Integer cityID) {
        CityID = cityID;
    }

    public Integer getProvinceID() {
        return ProvinceID;
    }

    public void setProvinceID(Integer provinceID) {
        ProvinceID = provinceID;
    }

    public Integer getFreeTime() {
        return FreeTime;
    }

    public void setFreeTime(Integer freeTime) {
        FreeTime = freeTime;
    }

    public String getStayTime() {
        return StayTime;
    }

    public void setStayTime(String stayTime) {
        StayTime = stayTime;
    }

    public Integer getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Integer customerID) {
        CustomerID = customerID;
    }
}
