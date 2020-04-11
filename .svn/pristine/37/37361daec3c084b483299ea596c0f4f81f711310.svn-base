package com.hq.adpush.controller;


import com.hq.adpush.entity.Advertisement_Park;
import com.hq.adpush.service.AdvertisementParkService;
import com.zzrb.ecc.AnboECCKey;
import com.zzrb.ecc.AnboECCSign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/Adpark")
public class AdvertisementParkController {
    @Autowired
    private AdvertisementParkService AdvertisementParkService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addAdPark(Advertisement_Park adpark){
        System.out.println("开始新增...");
        return AdvertisementParkService.addAdPark(adpark);
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean updateAdPark(Advertisement_Park adpark){
        System.out.println("开始更新...");
        return AdvertisementParkService.updateAdPark(adpark);
    }
    @RequestMapping(value = "/tosign", method = RequestMethod.POST)
    public String anbosign()throws Exception{

//        String keyPair = AnboECCKey.generateKeyPair();
//        System.out.println(keyPair);
        System.out.println("签名...");
        AnboECCSign anboECCSign=new AnboECCSign();
        Map<String,String> map = new HashMap<>();
        map.put("accountType","1");
        map.put("address","北京市朝阳区中电发展大厦");
        map.put("name","张三");
        map.put("bankName","招商银行");
        map.put("accountNo","6225888888888888");
        map.put("accountName","张三");
        System.out.println("map:"+map);

        String sign = anboECCSign.sign(map);
        System.out.println("sign:"+sign);
        return sign;

    }
}
