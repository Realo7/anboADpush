package com.hq.adpush.dao;

import com.hq.adpush.entity.AdContent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdContentDao {

    //通过停车场ID查找所有的信息
    @Select("SELECT * FROM T_BIZ_AdContent where parkId=#{parkId}")
    AdContent findbyparkId(String parkId);

    //通过停车场ID向表内更新信息
    @Update("update T_BIZ_AdContent set " +
            "adPosIds=#{adPosIds}," +
            "partnerId=#{partnerId}," +
            "status=#{status}," +
            "userMobile=#{userMobile}," +
            "userLicense=#{userLicense} " +
            "adType=#{adType} " +
            "content1=#{content1} " +
            "url=#{url} " +
            "adId=#{adId} " +
            "where parkId=#{parkId}")
    void updateAdConnect(AdContent ADC);

    //增加数据
    @Insert("insert into T_BIZ_AdContent" +
            "(adPosIds,partnerId,parkId,userMobile,userLicense,adType,content1,url,adId) " +
            "values " +
            "(#{adPosIds},#{partnerId},#{parkId},#{userMobile},#{userLicense},#{adType},#{content1,},#{url},#{adId})")
    void addAdConnect(AdContent ADC);
}
