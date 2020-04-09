package com.hq.adpush.service;

import com.hq.adpush.entity.Advertisement_Park;

public interface AdvertisementParkService {
 boolean addAdPark(Advertisement_Park AdPark);
 boolean updateAdPark(Advertisement_Park AdPark);
 Advertisement_Park findparkbyAdvertID(String AdvertID);
}
