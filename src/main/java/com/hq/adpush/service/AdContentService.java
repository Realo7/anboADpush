package com.hq.adpush.service;

import com.hq.adpush.entity.AdContent;
import org.springframework.beans.factory.annotation.Autowired;

public interface AdContentService {

    AdContent findbyparkId(String parkId);
    boolean addAdConnect(AdContent ADC);
    boolean updateAdConnect(AdContent ADC);
}
