package com.hq.adpush.dao;

import com.hq.adpush.entity.Advertisement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdvertisementDao {
    //向advertisement表中增加数据
    @Insert("insert into T_BIZ_Advertisement(AdvertID,name,regType,cityId,accountType,contactName,contactMobile,source,manager,accountName,bankName,accountNo,password,publicKey,sign,partnerId,CTime,MTime,Extend1,Extend2,Extend3,Status) " +
            "values (#{AdvertID},#{name},#{regType},#{cityId,},#{accountType},#{contactName},#{contactMobile},#{source},#{manager},#{accountName},#{bankName},#{accountNo},#{password},#{publicKey},#{sign},#{partnerId},#{CTime},#{MTime},#{Extend1},#{Extend2},#{Extend3},#{Status})")
    void addAd(Advertisement AD);

//    更新
    @Update("update T_BIZ_Advertisement set name=#{name},regType=#{regType},cityId=#{cityId},accountType=#{accountType},contactName=#{contactName},contactMobile=#{contactMobile},source=#{source},manager=#{manager},accountName=#{accountName},bankName=#{bankName},accountNo=#{accountNo},password=#{password},publicKey=#{publicKey},sign=#{sign},partnerId=#{partnerId},CTime=#{CTime},MTime=#{MTime},Extend1=#{Extend1},Extend2=#{Extend2},Extend3=#{Extend3},Status=#{Status} where AdvertID=#{AdvertID}")
    void updateAd(Advertisement AD);

    //通过广告主ID查找所有的信息
    @Select("SELECT * FROM T_BIZ_Advertisement where AdvertID=#{AdvertID}")
    Advertisement findbyAdvertID(String AdvertID);


    //查找
    @Select("SELECT * FROM T_BIZ_Advertisement")
    List<Advertisement> findall();
}
