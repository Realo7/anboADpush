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

}
