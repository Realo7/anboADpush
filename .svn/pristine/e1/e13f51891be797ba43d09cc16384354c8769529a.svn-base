package com.hq.adpush.controller;


import com.hq.adpush.entity.Advertisement;
import com.hq.adpush.service.AdService;
import com.zzrb.ecc.AnboECCSign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/Ad")
public class AdvertisementController {
    @Autowired
    private AdService AdService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean addAd(@RequestBody Advertisement AD, HttpServletRequest request){
        System.out.println("新增"+ AD);
        System.out.println("开始新增advertisement...");
        return AdService.addAd(AD);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean updateAd(Advertisement AD){
        System.out.println("开始更新advertisement...");
        return AdService.updateAd(AD);
    }

    @RequestMapping(value = "/findbyAdvertID", method = RequestMethod.POST)
    public Advertisement findbyAdvertID(String AdvertID){
        System.out.println("开始通过广告主ID寻找信息...");
        return AdService.findbyAdvertID(AdvertID);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public List<Advertisement> findAll(){
        System.out.println("开始新增advertisement...");
        return AdService.findAll();
    }

//    对通过广告主ID查找到的信息进行加密
@RequestMapping(value = "/secretbyAdvertID", method = RequestMethod.POST)
@ResponseBody
public String secretinfo(String AdvertID)throws Exception{
    System.out.println("开始..."+AdvertID);
    System.out.println("开始通过广告主ID寻找信息...");
    Advertisement ad = AdService.findbyAdvertID(AdvertID);
    System.out.println("bububub..."+ad);

    //对找到的信息进行签名
    AnboECCSign anboECCSign = new AnboECCSign();
    Map<String,String> map = new HashMap<>();
    map.put("accountType",ad.getAccountType());
    map.put("address",ad.getCityId());
    map.put("name",ad.getName());
    map.put("bankName",ad.getBankName());
    map.put("accountNo",ad.getAccountNo());
    map.put("accountName",ad.getAccountName());
    System.out.println("map:"+map);
    String sign = anboECCSign.sign(map);

    return sign;
}


}
