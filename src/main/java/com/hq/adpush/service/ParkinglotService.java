package com.hq.adpush.service;

import com.hq.adpush.entity.Parkinglot;

public interface ParkinglotService {
    boolean addpkl(Parkinglot pkl);

    Parkinglot findbyParklotID(String ParklotID);
}
