package com.hq.adpush.service;

import com.hq.adpush.entity.Advertisement;

import java.util.List;

public interface AdService {
    boolean addAd(Advertisement AD);
    boolean updateAd(Advertisement AD);
    Advertisement findbyAdvertID(String AdvertID);
    List<Advertisement> findAll();
}
