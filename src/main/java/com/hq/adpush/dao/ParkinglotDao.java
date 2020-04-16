package com.hq.adpush.dao;

import com.hq.adpush.entity.Parkinglot;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ParkinglotDao {

//    插入数据
    @Insert("insert into T_BIZ_Advertisement" +
            "(ParkinglotID," +
            "ParkinglotName," +
            "Address," +
            "TEL," +
            "Mobile," +
            "URL," +
            "Longitude," +
            "Latitude," +
            "Status," +
            "Grade," +
            "CTime," +
            "MTime," +
            "TotalSpace," +
            "SurplusSpace," +
            "Account," +
            "Redpackets," +
            "Extend1," +
            "Extend2," +
            "Extend3," +
            "Extend4," +
            "Extend5," +
            "LocalServerIP," +
            "LocalServerPort," +
            "LastCommTime," +
            "HeartbeatInterval," +
            "UpDownTime," +
            "DataStatus," +
            "FeteDayID," +
            "RestDayID," +
            "Images," +
            "District," +
            "CityID," +
            "ProvinceID," +
            "FreeTime," +
            "StayTime," +
            "CustomerID) " +
            "values " +
            "(#{ParkinglotID},#{ParkinglotName},#{Address},#{TEL},#{Mobile}," +
            "#{URL},#{Longitude},#{Latitude},#{Status}," +
            "#{Grade},#{CTime},#{MTime},#{TotalSpace}," +
            "#{SurplusSpace},#{Account},#{Redpackets},#{Extend1},#{Extend2}," +
            "#{Extend3},#{Extend4},#{Extend5},#{LocalServerIP},#{LocalServerPort}," +
            "#{LastCommTime},#{HeartbeatInterval},#{UpDownTime},#{DataStatus},#{FeteDayID}," +
            "#{RestDayID},#{Images},#{District},#{CityID}," +
            "#{ProvinceID},#{FreeTime},#{StayTime},#{CustomerID})"
    )
    void addpkl(Parkinglot pklot);

    // 通过parkinglotID查询该下的所有信息
    @Select("SELECT * FROM T_PAK_Parkinglot where ParkinglotID=#{ParkinglotID}")
    Parkinglot findbyParkinglotID(String ParkinglotID);

    //通过parkinglotID插入

}
