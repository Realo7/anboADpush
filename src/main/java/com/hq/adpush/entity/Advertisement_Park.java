package com.hq.adpush.entity;

public class Advertisement_Park {
    //id
    private Integer ID;
    //
    private String ParkId;
    //
    private String AdvertID;
    //
    private String parkName;
    //
    private String cityId;
    //
    private String partnerId;
    //
    private String sign;
    //
    private Integer status;
    //
    private String ParkinglotID;

    private String adPosIds;

    private String userMobile;

    private String userLicense;

    private String adId;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getParkId() {
        return ParkId;
    }

    public void setParkId(String parkId) {
        ParkId = parkId;
    }

    public String getAdvertID() {
        return AdvertID;
    }

    public void setAdvertID(String advertID) {
        AdvertID = advertID;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getParkinglotID() {
        return ParkinglotID;
    }

    public void setParkinglotID(String parkinglotID) {
        ParkinglotID = parkinglotID;
    }

    public String getAdPosIds() {
        return adPosIds;
    }

    public void setAdPosIds(String adPosIds) {
        this.adPosIds = adPosIds;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserLicense() {
        return userLicense;
    }

    public void setUserLicense(String userLicense) {
        this.userLicense = userLicense;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    @Override
    public String toString() {
        return "Advertisement_Park{" +
                "ID=" + ID +
                ", ParkId='" + ParkId + '\'' +
                ", AdvertID='" + AdvertID + '\'' +
                ", parkName='" + parkName + '\'' +
                ", cityId='" + cityId + '\'' +
                ", partnerId='" + partnerId + '\'' +
                ", sign='" + sign + '\'' +
                ", status=" + status +
                ", ParkinglotID='" + ParkinglotID + '\'' +
                ", adPosIds='" + adPosIds + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userLicense='" + userLicense + '\'' +
                ", adId='" + adId + '\'' +
                '}';
    }
}
