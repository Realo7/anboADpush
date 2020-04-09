package com.hq.adpush.service.impl;

import com.hq.adpush.entity.Advertisement;
import com.hq.adpush.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private com.hq.adpush.dao.AdvertisementDao AdvertisementDao;

    @Override
    public boolean addAd(Advertisement AD) {
        boolean flag=false;
        try{
            AdvertisementDao.addAd(AD);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateAd(Advertisement AD) {
        boolean flag=false;
        try{
            AdvertisementDao.updateAd(AD);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Advertisement findbyAdvertID(String AdvertID) {
        return AdvertisementDao.findbyAdvertID(AdvertID);
    }

    @Override
    public List<Advertisement> findAll() {
        return AdvertisementDao.findall();
    }
}
