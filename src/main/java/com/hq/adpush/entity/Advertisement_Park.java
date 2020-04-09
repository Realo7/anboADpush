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
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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
}
