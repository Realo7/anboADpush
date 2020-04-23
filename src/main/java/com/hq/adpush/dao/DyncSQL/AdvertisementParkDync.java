package com.hq.adpush.dao.DyncSQL;

import com.hq.adpush.entity.Advertisement_Park;
import com.microsoft.sqlserver.jdbc.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class AdvertisementParkDync {
    public String dyncupdate(final Advertisement_Park adp){
        return new SQL() {
            {
                UPDATE("T_BIZ_Advertisement_Park");

                //通过条件 判断是否需要更新该字段
                if (!StringUtils.isEmpty(adp.getParkId())) {
                    SET("ParkId = #{ParkId}");
                }
                if (!StringUtils.isEmpty(adp.getParkName())) {
                    SET("parkName = #{parkName}");
                }
                if (!StringUtils.isEmpty(adp.getCityId())) {
                    SET("cityId = #{cityId}");
                }
                if (!StringUtils.isEmpty(adp.getSign())) {
                    SET("sign = #{sign}");
                }
                if (!StringUtils.isEmpty(adp.getPartnerId())) {
                    SET("partnerId = #{partnerId}");
                }
                if (adp.getStatus()!=null) {
                    SET("status = #{status}");
                }
                WHERE("ParkinglotID = #{ParkinglotID}");
            }
        }.toString();
    }
}
