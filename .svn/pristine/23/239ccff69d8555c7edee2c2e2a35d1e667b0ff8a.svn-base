package com.hq.adpush.dao;

import com.hq.adpush.entity.AdContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdContentDao {

    //通过停车场ID查找所有的信息
    @Select("SELECT * FROM T_BIZ_AdContent where parkId=#{parkId}")
    AdContent findbyparkId(String parkId);
}
