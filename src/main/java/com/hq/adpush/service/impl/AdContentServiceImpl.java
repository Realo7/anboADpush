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
}
