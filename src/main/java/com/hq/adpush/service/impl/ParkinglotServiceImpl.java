package com.hq.adpush.service.impl;

import com.hq.adpush.entity.Parkinglot;
import com.hq.adpush.service.ParkinglotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkinglotServiceImpl implements ParkinglotService {
    @Autowired
    private com.hq.adpush.dao.ParkinglotDao ParkinglotDao;

    @Override
    public boolean addpkl(Parkinglot pkl) {
        boolean flag=false;
        try{
            ParkinglotDao.addpkl(pkl);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Parkinglot findbyParklotID(String ParklotID) {
        return ParkinglotDao.findbyParkinglotID(ParklotID);
    }
}
