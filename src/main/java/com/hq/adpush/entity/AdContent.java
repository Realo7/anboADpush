package com.hq.adpush.entity;

public class AdContent {
    private String ID;
    private String adPosIds;
    private String partnerId;
    private String parkId;
    private String status;
    private String userMobile;
    private String userLicense;
    private String adType;
    private String content1;
    private String url;
    private String adId;

    @Override
    public String toString() {
        return "AdContent{" +
                "ID='" + ID + '\'' +
                ", adPosIds='" + adPosIds + '\'' +
                ", partnerId='" + partnerId + '\'' +
                ", parkId='" + parkId + '\'' +
                ", status='" + status + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userLicense='" + userLicense + '\'' +
                ", adType='" + adType + '\'' +
                ", content1='" + content1 + '\'' +
                ", url='" + url + '\'' +
                ", adId='" + adId + '\'' +
                '}';
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAdPosIds() {
        return adPosIds;
    }

    public void setAdPosIds(String adPosIds) {
        this.adPosIds = adPosIds;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
