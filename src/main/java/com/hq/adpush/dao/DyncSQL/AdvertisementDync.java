package com.hq.adpush.dao.DyncSQL;

import com.hq.adpush.entity.Advertisement;
import com.microsoft.sqlserver.jdbc.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class AdvertisementDync extends SQL{
    public String dyncupdate(Advertisement ad){
        return new SQL() {
            {
                UPDATE("T_BIZ_Advertisement");

                //通过条件 判断是否需要更新该字段
                if (!StringUtils.isEmpty(ad.getName())) {
                    SET("name = #{name}");
                }
                if (!StringUtils.isEmpty(ad.getRegType())) {
                    SET("regType = #{regType}");
                }
                if (!StringUtils.isEmpty(ad.getCityId())) {
                    SET("cityId = #{cityId}");
                }
                if (!StringUtils.isEmpty(ad.getAccountType())) {
                    SET("accountType = #{accountType}");
                }
                if (!StringUtils.isEmpty(ad.getCityId())) {
                    SET("contactName = #{contactName}");
                }
                if (!StringUtils.isEmpty(ad.getContactMobile())) {
                    SET("contactMobile = #{contactMobile}");
                }
                if (!StringUtils.isEmpty(ad.getSource())) {
                    SET("source = #{source}");
                }
                if (!StringUtils.isEmpty(ad.getManager())) {
                    SET("manager = #{manager}");
                }
                if (!StringUtils.isEmpty(ad.getAccountName())) {
                    SET("accountName = #{accountName}");
                }
                if (!StringUtils.isEmpty(ad.getBankName())) {
                    SET("bankName = #{bankName}");
                }
                if (!StringUtils.isEmpty(ad.getAccountNo())) {
                    SET("accountNo = #{accountNo}");
                }
                if (!StringUtils.isEmpty(ad.getPassword())) {
                    SET("password = #{password}");
                }
                if (!StringUtils.isEmpty(ad.getPublicKey())) {
                    SET("publicKey = #{publicKey}");
                }
                if (!StringUtils.isEmpty(ad.getSign())) {
                    SET("sign = #{sign}");
                }
                if (!StringUtils.isEmpty(ad.getPartnerId())) {
                    SET("partnerId = #{partnerId}");
                }
//                if (!StringUtils.isEmpty(ad.getCTime().toString())) {
//                    SET("CTime = #{CTime}");
//                }
//                if (!StringUtils.isEmpty(ad.getMTime().toString())) {
//                    SET("MTime = #{MTime}");
//                }
                if (!StringUtils.isEmpty(ad.getExtend1())) {
                    SET("Extend1 = #{Extend1}");
                }
                if (!StringUtils.isEmpty(ad.getExtend2())) {
                    SET("Extend2 = #{Extend2}");
                }
                if (!StringUtils.isEmpty(ad.getExtend3())) {
                    SET("Extend3 = #{Extend3}");
                }
                if (ad.getStatus()!=null) {
                    SET("Status = #{Status}");
                }

                WHERE("AdvertID = #{AdvertID}");

            }
        }.toString();
    }
}
