package com.hq.adpush.service;

import com.hq.adpush.entity.Advertisement;
import com.hq.adpush.entity.Advertisement_Park;

public interface AdvertisementParkService {
 boolean addAdPark(Advertisement_Park AdPark);
 boolean updateAdPark(Advertisement_Park AdPark);
 Advertisement_Park findparkbyAdvertID(String AdvertID);
 Advertisement_Park findparkbyAdvertIDandparkId(String AdvertID,String parkId);
 String findpartnerIdbyparkId(String parkId);
 String findpartnerIdbyParkinglotID(String parkinglotID);
 String findparkIdbyParkinglotID(String ParkinglotID);
 String findParkinglotIDbyparkId(String parkId);
 String findadPosIdsbyParkinglotID(String ParkinglotID);
 Advertisement_Park findstatus0byAdvertID(String AdvertID);
 Advertisement_Park findbyParkinglotID(String ParkinglotID);
}
