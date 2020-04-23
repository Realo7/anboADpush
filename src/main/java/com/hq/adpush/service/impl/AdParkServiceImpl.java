package com.hq.adpush.service.impl;

import com.hq.adpush.entity.Advertisement;
import com.hq.adpush.entity.Advertisement_Park;
import com.hq.adpush.service.AdvertisementParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdParkServiceImpl implements AdvertisementParkService {
    @Autowired
    private com.hq.adpush.dao.AdvertisementParkDao AdvertisementParkDao;

    @Override
    public boolean addAdPark(Advertisement_Park AdPark) {
        boolean flag=false;
        try{
            AdvertisementParkDao.addAdPark(AdPark);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateAdPark(Advertisement_Park AdPark) {
        boolean flag=false;
        try{
            AdvertisementParkDao.updateAdPark(AdPark);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Advertisement_Park findparkbyAdvertID(String AdvertID) {
        return AdvertisementParkDao.findparkbyAdvertID(AdvertID);
    }

    @Override
    public Advertisement_Park findparkbyAdvertIDandparkId(String AdvertID, String parkId) {
        return AdvertisementParkDao.findparkbyAdvertIDandparkId(AdvertID,parkId);
    }

    @Override
    public String findpartnerIdbyparkId(String parkId) {
        return AdvertisementParkDao.findpartnerIdbyparkId(parkId);
    }

    @Override
    public String findpartnerIdbyParkinglotID(String parkinglotID) {
        return AdvertisementParkDao.findpartnerIdbyParkinglotID(parkinglotID);
    }

    @Override
    public String findparkIdbyParkinglotID(String ParkinglotID) {
        return AdvertisementParkDao.findparkIdbyParkinglotID(ParkinglotID);
    }

    @Override
    public String findParkinglotIDbyparkId(String parkId) {
        return AdvertisementParkDao.findParkinglotIDbyparkId(parkId);
    }

    @Override
    public String findadPosIdsbyParkinglotID(String ParkinglotID) {
        return AdvertisementParkDao.findadPosIdsbyParkinglotID(ParkinglotID);
    }

    @Override
    public Advertisement_Park findstatus0byAdvertID(String AdvertID) {
        return AdvertisementParkDao.findstatus0byAdvertID(AdvertID);
    }

    @Override
    public Advertisement_Park findbyParkinglotID(String ParkinglotID) {
        return AdvertisementParkDao.findbyParkinglotID(ParkinglotID);
    }


}
