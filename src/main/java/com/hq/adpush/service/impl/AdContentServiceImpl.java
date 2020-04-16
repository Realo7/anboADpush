package com.hq.adpush.service.impl;

import com.hq.adpush.entity.AdContent;
import com.hq.adpush.service.AdContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdContentServiceImpl implements AdContentService {
    @Autowired
    private com.hq.adpush.dao.AdContentDao AdContentDao;
    @Override
    public AdContent findbyparkId(String parkId) {
        return AdContentDao.findbyparkId(parkId);
    }

    @Override
    public boolean addAdConnect(AdContent ADC) {
        boolean flag=false;
        try{
            AdContentDao.addAdConnect(ADC);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateAdConnect(AdContent ADC) {
        boolean flag=false;
        try{
            AdContentDao.updateAdConnect(ADC);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
