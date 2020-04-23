package com.hq.adpush.dao;

import com.hq.adpush.dao.DyncSQL.AdvertisementParkDync;
import com.hq.adpush.entity.Advertisement_Park;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdvertisementParkDao {
    //增加数据
    @Insert("insert into T_BIZ_Advertisement_Park(parkId,AdvertID,parkName,cityId,partnerId,status) values (#{parkId},#{AdvertID},#{parkName},#{cityId},#{partnerId},#{status})")
    void addAdPark(Advertisement_Park ADpark);


    //通过广告主ID查找所有的信息
    @Select("SELECT * FROM T_BIZ_Advertisement_Park where AdvertID=#{AdvertID}")
    Advertisement_Park findparkbyAdvertID(String AdvertID);

    //通过广告主ID和parkId查找所有的信息
    @Select("SELECT Top 1 * FROM T_BIZ_Advertisement_Park where AdvertID=#{AdvertID} AND parkId=#{parkId}")
    Advertisement_Park findparkbyAdvertIDandparkId(String AdvertID,String parkId);

    //动态拼接sql,来进行数据的更新
    @UpdateProvider(type = AdvertisementParkDync.class,method = "dyncupdate")
    boolean updateAdPark(Advertisement_Park ADpark);

    //通过parkId去查partnerId
    @Select("SELECT partnerId FROM T_BIZ_Advertisement_Park where parkId=#{parkId}")
    String findpartnerIdbyparkId(String parkId);

    //通过parkinglotID去查partnerId
    @Select("SELECT partnerId FROM T_BIZ_Advertisement_Park where ParkinglotID=#{parkId}")
    String findpartnerIdbyParkinglotID(String ParkinglotID);

    //通过parkinglotId查parkId
    @Select("SELECT ParkId FROM T_BIZ_Advertisement_Park where ParkinglotID=#{ParkinglotID}")
    String findparkIdbyParkinglotID(String ParkinglotID);

    //通过parkId查parkinglotId
    @Select("SELECT ParkinglotID FROM T_BIZ_Advertisement_Park where ParkId=#{parkId}")
    String findParkinglotIDbyparkId(String parkId);

    //查找状态为0（Status=0）的信息
    @Select("SELECT TOP 1  * FROM T_BIZ_Advertisement_Park WHERE Status=0 AND AdvertID=#{AdvertID};")
    Advertisement_Park findstatus0byAdvertID(String AdvertID);

    //通过parkinglotId查adPosIds
    @Select("SELECT adPosIds FROM T_BIZ_Advertisement_Park where ParkinglotID=#{ParkinglotID}")
    String findadPosIdsbyParkinglotID(String ParkinglotID);

    //查找parkinglotId的所有信息
    @Select("SELECT TOP 1  * FROM T_BIZ_Advertisement_Park WHERE ParkinglotID=#{ParkinglotID};")
    Advertisement_Park findbyParkinglotID(String ParkinglotID);
}
