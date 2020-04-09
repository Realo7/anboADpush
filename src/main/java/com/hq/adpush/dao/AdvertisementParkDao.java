package com.hq.adpush.dao;

import com.hq.adpush.entity.Advertisement_Park;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdvertisementParkDao {
    //增加数据
    @Insert("insert into T_BIZ_Advertisement_Park(parkId,AdvertID,parkName,cityId,partnerId,status) values (#{parkId},#{AdvertID},#{parkName},#{cityId},#{partnerId},#{status})")
    void addAdPark(Advertisement_Park ADpark);

    @Update("update T_BIZ_Advertisement_Park set parkId=#{parkId},parkName=#{parkName},cityId=#{cityId},partnerId=#{partnerId},status=#{status} where AdvertID=#{advertID}")
    void updateAdPark(Advertisement_Park ADpark);

    //通过广告主ID查找所有的信息
    @Select("SELECT * FROM T_BIZ_Advertisement_Park where AdvertID=#{AdvertID}")
    Advertisement_Park findparkbyAdvertID(String AdvertID);
}
