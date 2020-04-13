package com.hq.adpush.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hq.adpush.entity.AdContent;
import com.hq.adpush.entity.Advertisement;
import com.hq.adpush.entity.Advertisement_Park;
import com.hq.adpush.service.AdContentService;
import com.hq.adpush.service.AdService;
import com.hq.adpush.service.AdvertisementParkService;
import com.hq.adpush.util.httpconnect;
import com.hq.adpush.util.restnet;
import com.zzrb.ecc.AnboECCEncrypt;
import com.zzrb.ecc.AnboECCSign;

import com.zzrb.ecc.AnboECCVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sun.security.x509.X509CertImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/cr")
public class CreatAccount {
    @Autowired
    private AdService AdService;
    @Autowired
    private AdvertisementParkService AdvertisementParkService;
    @Autowired
    private AdContentService AdContentService;

    private httpconnect httpconnect;

    //    JSONObject obj = new JSONObject();
    //新建一个账户
    @RequestMapping(value = "/tocreataccount", method = RequestMethod.POST)
    @ResponseBody
    public String tocreataccount(String AdvertID) throws Exception {
        //此处将要发送的数据转换为map格式
        System.out.println("开始通过广告主ID寻找信息...");
        Advertisement ad = AdService.findbyAdvertID(AdvertID);

        if (ad.getStatus()==1){
            return "该账户已被创建";
        }else {
            //此处用来创建账户
            //对找到的信息进行签名
            AnboECCSign anboECCSign = new AnboECCSign();
            Map<String, String> map = new HashMap<>();
            map.put("name", ad.getName());
            map.put("regType", ad.getRegType());
            map.put("cityId", ad.getCityId());
            map.put("accountType", ad.getAccountType());
            map.put("contactName", ad.getAccountName());
            map.put("contactMobile", ad.getContactMobile());
            map.put("source", ad.getSource());
            map.put("manager", ad.getManager());
            map.put("accountName", ad.getAccountName());
            map.put("bankName", ad.getBankName());
            map.put("accountNo", ad.getAccountNo());

//        对密码进行加密
            AnboECCEncrypt anboECCEncrypt = new AnboECCEncrypt();
            String dataEncryptpas = anboECCEncrypt.encrypt(ad.getPassword());

            map.put("password", dataEncryptpas);

            map.put("publicKey", ad.getPublicKey());

            String sign = anboECCSign.sign(map);
            System.out.println("签名：" + sign);


//            AnboECCVerify anboECCVerify = new AnboECCVerify();
//            Boolean check = anboECCVerify.verify(map,sign);
//            System.out.println("check:"+check);

            map.put("sign", sign);

            System.out.println("签名后的需要提交的信息：" + map);

            String api = "account";


            JSONObject obj = httpconnect.doitpost(map, api);

            JSONObject object = obj.getJSONObject("result");

//        把创建获得的partnerId传到数据库
            if (object != null) {
                Advertisement ad01 = new Advertisement();

                ad01.setPartnerId(object.get("partnerId").toString());
                ad01.setStatus(1);
                boolean tr = AdService.updateAd(ad01);

                System.out.println("添加结果：" + tr);
//                然后通过这个partnerID去创建车场
                this.tocreatePark(AdvertID);
            }

            return obj.toString();
        }
    }

    //    更新账户信息
    @RequestMapping(value = "/toupdateaccount", method = RequestMethod.POST)
    @ResponseBody
    public String toupdateaccount(String AdvertID) throws Exception {
        //此处将要发送的数据转换为map格式
        System.out.println("开始通过广告主ID寻找信息...");
        Advertisement ad = AdService.findbyAdvertID(AdvertID);
        //此处用来创建账户
        //对找到的信息进行签名
        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();
        map.put("name", ad.getName());
        map.put("regType", ad.getRegType());
        map.put("cityId", ad.getCityId());
        map.put("accountType", ad.getAccountType());
        map.put("contactName", ad.getAccountName());
        map.put("contactMobile", ad.getContactMobile());
        map.put("source", ad.getSource());
        map.put("manager", ad.getManager());
        map.put("accountName", ad.getAccountName());
        map.put("bankName", ad.getBankName());
        map.put("accountNo", ad.getAccountNo());
        //对密码进行加密后再把密码放在map里面
        AnboECCEncrypt anboECCEncrypt = new AnboECCEncrypt();
        String dataEncryptpas = anboECCEncrypt.encrypt(ad.getPassword());

        map.put("password", dataEncryptpas);
        map.put("publicKey", ad.getPublicKey());
        map.put("partnerId", ad.getPartnerId());

//        对map信息进行签名
        String sign = anboECCSign.sign(map);
        System.out.println("签名：" + sign);

        //验签
        AnboECCVerify anboECCVerify = new AnboECCVerify();
        Boolean check = anboECCVerify.verify(map, sign);
        System.out.println("check:" + check);

//        验证签名之后把签名信息放在map里面
        map.put("sign", sign);

        System.out.println("加密后的需要提交的信息：" + map);

        String api = "account";

        return httpconnect.doitput(map, api).toString();
    }

    //创建车场
    @RequestMapping(value = "/tocreatePark", method = RequestMethod.POST)
    @ResponseBody
    public String tocreatePark(String AdvertID) throws Exception {
        //此处将要发送的数据转换为map格式
        System.out.println("开始通过广告主ID寻找车场信息...");
        Advertisement_Park ad = AdvertisementParkService.findparkbyAdvertID(AdvertID);
        //此处用来创建停车场
        //对找到的信息进行签名
        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();
        map.put("parkName", ad.getParkName());
        map.put("status", ad.getStatus().toString());
        map.put("cityId", ad.getCityId());
        map.put("partnerId", ad.getPartnerId());

        String sign = anboECCSign.sign(map);
        System.out.println("签名：" + sign);
        map.put("sign", sign);

        System.out.println("签名后的需要提交的信息：" + map);

        String api = "park";

        return httpconnect.doitpost(map, api).toString();
    }

    //    更新车场信息
    @RequestMapping(value = "/toupdatepark", method = RequestMethod.POST)
    @ResponseBody
    public String toupdatepark(String AdvertID) throws Exception {
        //此处将要发送的数据转换为map格式
        System.out.println("开始通过广告主ID寻找信息...");
        Advertisement_Park ad = AdvertisementParkService.findparkbyAdvertID(AdvertID);
        //此处用来创建账户
        //对找到的信息进行签名
        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();
        map.put("parkName", ad.getParkName());
        map.put("status", ad.getStatus().toString());
        map.put("cityId", ad.getCityId());
        map.put("partnerId", ad.getPartnerId());
        String sign = anboECCSign.sign(map);
        System.out.println("加密后的信息：" + sign);
        map.put("sign", sign);

        System.out.println("加密后的需要提交的信息：" + map);

        String api = "park";

//        doitpost(map,api);
        return httpconnect.doitput(map, api).toString();
    }

    //    获取车场信息
    @RequestMapping(value = "/getpark", method = RequestMethod.POST)
    @ResponseBody
    public String getpark(String AdvertID) throws Exception {
        //此处将要发送的数据转换为map格式
        Advertisement_Park ad = AdvertisementParkService.findparkbyAdvertID(AdvertID);

        Map<String, String> map = new HashMap<>();
        map.put("parkId", ad.getParkId());
        map.put("partnerId", ad.getPartnerId());

        System.out.println("需要提交的信息：" + map);

        String api = "park";

//        把获取到的车场信息传到数据库

//        在这进行JSON格式中含数组的取值
        JSONObject obj=httpconnect.doitget(map, api);

        JSONArray object = obj.getJSONArray("result");

        System.out.println("水水水水水水水水：" +object.getJSONObject(0).get("parkName"));

        return httpconnect.doitget(map, api).toString();
    }

    //    新增/更新广告位信息
    @RequestMapping(value = "/addADinfo", method = RequestMethod.POST)
    @ResponseBody
    public String addADinfo(String parkId) throws Exception {
        //此处将要发送的数据转换为map格式
        System.out.println("开始通过车场ID寻找信息...");
        AdContent ad = AdContentService.findbyparkId(parkId);
        //此处用来创建账户
        //对找到的信息进行签名
        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();
        map.put("adPosIds", ad.getAdPosIds());
        map.put("status", ad.getStatus().toString());
        map.put("parkId", ad.getParkId());
        map.put("partnerId", ad.getPartnerId());
        String sign = anboECCSign.sign(map);
        System.out.println("加密后的信息：" + sign);
        map.put("sign", sign);

        System.out.println("加密后的需要提交的信息：" + map);

        String api = "advert-pos";

//        doitpost(map,api);
        return httpconnect.doitput(map, api).toString();
    }

    //    获取广告位信息
    @RequestMapping(value = "/getADwinfo", method = RequestMethod.POST)
    @ResponseBody
    public String getADwinfo(String parkId) throws Exception {
        //此处将要发送的数据转换为map格式
        System.out.println("开始通过停车场ID寻找信息...");
        AdContent ad = AdContentService.findbyparkId(parkId);
        //此处用来创建账户
        //对找到的信息进行签名
        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();

        map.put("parkId", ad.getParkId());
        map.put("partnerId", ad.getPartnerId());

        String api = "advert-pos";

        JSONObject obj=httpconnect.doitget(map, api);


        return obj.toString();
    }

    //    获取广告
    @RequestMapping(value = "/getAD", method = RequestMethod.POST)
    @ResponseBody
    public String getAD(String parkId) throws Exception {
        //此处将要发送的数据转换为map格式
        System.out.println("开始通过广告主ID寻找信息...");
        AdContent ad = AdContentService.findbyparkId(parkId);
        //此处用来创建账户
        //对找到的信息进行签名
        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();
        map.put("parkId", ad.getParkId());
        map.put("partnerId", ad.getPartnerId());
        map.put("adPosId", ad.getAdPosIds());
        map.put("userMobile", ad.getUserMobile());
        map.put("userLicense", ad.getUserLicense());

        String sign = anboECCSign.sign(map);
        System.out.println("签名：" + sign);
        map.put("sign", sign);

        System.out.println("签名后的需要提交的信息：" + map);

        String api = "advert";

        JSONObject obj = httpconnect.doitget(map, api);

//        把获取到的广告url存到数据库
        JSONObject object = (JSONObject) obj.getJSONObject("result");

        System.out.println("水水水水水水水水：" +object.toString());

//        把创建获得的partnerId传到数据库
        if (object != null) {
            AdContent adc = new AdContent();

            adc.setContent1(object.get("content").toString());
            adc.setContent1(object.get("adId").toString());
            adc.setContent1(object.get("adType").toString());
            adc.setContent1(object.get("url").toString());

            boolean tr = AdContentService.updateAdConnect(adc);

            System.out.println("添加结果：" + tr);
        }

        return obj.toString();

    }

    //    广告跳转
    @RequestMapping(value = "/jumpAD", method = RequestMethod.POST)
    @ResponseBody
    public String jumpAD(String parkId) throws Exception {
        //此处将要发送的数据转换为map格式
        System.out.println("开始通过广告主ID寻找信息...");
        AdContent ad = AdContentService.findbyparkId(parkId);
        //此处用来创建账户
        //对找到的信息进行签名
        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();
        map.put("parkId", ad.getParkId());
        map.put("adId", ad.getAdId());
        map.put("adPosId", ad.getAdPosIds());
        map.put("userMobile", ad.getUserMobile());
        map.put("userLicense", ad.getUserLicense());

        String sign = anboECCSign.sign(map);
        System.out.println("加密后的信息：" + sign);
        map.put("sign", sign);

        System.out.println("加密后的需要提交的信息：" + map);

        String api = "advert/redirect";

//        doitpost(map,api);
        return httpconnect.doitget(map, api).toString();
    }

}
