package com.hq.adpush.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hq.adpush.entity.Advertisement;
import com.hq.adpush.entity.Advertisement_Park;
import com.hq.adpush.entity.Parkinglot;
import com.hq.adpush.service.AdService;
import com.hq.adpush.service.AdvertisementParkService;
import com.hq.adpush.service.ParkinglotService;
import com.hq.adpush.util.httpconnect;
import com.zzrb.ecc.AnboECCEncrypt;
import com.zzrb.ecc.AnboECCSign;

import com.zzrb.enumm.CityIdEnum;
import com.zzrb.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class CreatAccount {
    @Autowired
    private AdService AdService;
    @Autowired
    private AdvertisementParkService AdvertisementParkService;
    @Autowired
    private ParkinglotService ParklotService;

    private httpconnect httpconnect;

    private static final Logger LOG = LoggerFactory.getLogger(CreatAccount.class);

    //    JSONObject obj = new JSONObject();
    //新建一个账户
    @PostConstruct
    @RequestMapping(value = "/tocreataccount", method = RequestMethod.POST)
    @ResponseBody
    public String tocreataccount() throws Exception {
        //此处将要发送的数据转换为map格式
        LOG.warn("开始寻找状态码为0的第一条商户信息...");
        LOG.warn("-----------开始创建账户-----------");
        Advertisement ad = AdService.findstatus0();

        String privateKeyStr1 = FileUtil.getKeyStrByResources("key_pair.json", "priv_key", "value");
        System.out.println("获取到key_pair的私钥"+privateKeyStr1);
        String privateKeyStr2 = FileUtil.getKeyStrByResources("key_pair.json", "pub_key", "value");
        System.out.println("获取到key_pair的公钥"+privateKeyStr2);
        String privateKeyStr3 = FileUtil.getKeyStrByResources("anbo_pub_key.json", "pub_key", "value");
        System.out.println("获取到anbo_pub_key的公钥"+privateKeyStr3);

        if (ad != null) {

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
            map.put("sign", sign);

            LOG.warn("签名后的需要提交的信息：" + map);

            String api = "account";

            JSONObject obj = httpconnect.doitpost(map, api);

            Object object1 = obj.get("message");
            System.out.println("message：" + object1);
            if (obj.get("status").equals("20000000")) {
                JSONObject object = obj.getJSONObject("result");
                LOG.warn("创建成功返回的数据result：" + object.toString());
                // 把创建获得的partnerId传到数据库
                Advertisement ad01 = new Advertisement();

                ad01.setPartnerId(object.get("partnerId").toString());
                ad01.setStatus(1);
                ad01.setAdvertID(ad.getAdvertID());
                LOG.warn("创建成功，向数据库里面更新的数据" + ad01);

                boolean tr = AdService.updateAd(ad01);

                LOG.warn("添加结果：" + tr);
//                然后通过这个partnerID去创建车场
                this.tocreatePark(ad.getAdvertID());
            }
            System.out.println("创建返回的状态码不等于20000000");
            return obj.toString();
        } else {
            System.out.println("查找状态为0，但是没有数据，于是去查有partnerId的内容，调用更新内容的方法");
            Advertisement adfnb = AdService.findpartnerIdnotblank();
            String upAdvertID=adfnb.getAdvertID();
            this.toupdateaccount(upAdvertID);
            return "数据库内的商户都已经激活";
        }

    }

    //    更新账户信息
    @RequestMapping(value = "/toupdateaccount", method = RequestMethod.POST)
    @ResponseBody
    public String toupdateaccount(String AdvertID) throws Exception {
        //此处将要发送的数据转换为map格式
        LOG.warn("-----------更新账户信息-----------开始通过广告主ID寻找信息...");
        Advertisement ad = AdService.findbyAdvertID(AdvertID);

        if (ad==null){
            return "没有该广告主下的账户信息";
        }
        //此处用来创建账户
        //对找到的信息进行签名
        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();
//        map.put("name", ad.getName());
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
        map.put("partnerId", ad.getPartnerId());

//        对map信息进行签名
        String sign = anboECCSign.sign(map);
        map.put("sign", sign);

        LOG.warn("加密后的需要提交的信息：" + map);

        String api = "account";

        JSONObject obj = httpconnect.doitput(map, api);

        if (obj.get("status").equals("20000000")) {
            JSONObject object = obj.getJSONObject("result");
            LOG.warn("更新成功返回的数据result：" + object.toString());
//            通过更新数据中的advertID去创建车场
            this.tocreatePark(ad.getAdvertID());
            return obj.toString();
        }else{
            LOG.warn("更新账户信息失败或您提交的信息都已是最新");
            return obj.toString();
        }

    }

    //创建车场
    @RequestMapping(value = "/tocreatePark", method = RequestMethod.POST)
    @ResponseBody
    public String tocreatePark(String AdvertID) throws Exception {
        //此处将要发送的数据转换为map格式
        LOG.warn("创建车场----------开始通过广告主ID寻找该广告主下状态为0的车场信息...");
        Advertisement_Park adp = AdvertisementParkService.findstatus0byAdvertID(AdvertID);
        if (adp==null){
            System.out.println("没找到该广告主ID下状态为0的停车场，该广告主ID下的停车场都已创建，如果想要更新车场数据，请手动调用停车场更新");
            //停车场更新
//            this.toupdatepark(AdvertID);

            return "没找到该广告主ID下状态为0的停车场，如果想要更新车场数据，请手动调用停车场更新";
        }
        Advertisement ad = AdService.findbyAdvertID(AdvertID);
        if (ad==null){
            return "没找到该广告主ID下的账户信息";
        }
        System.out.println("-----------------------"+adp.getParkinglotID());
        Parkinglot pkl=ParklotService.findbyParklotID(adp.getParkinglotID());
        if (pkl==null){
            System.out.println("在parkingLOT表中没找到"+adp.getParkinglotID()+"的信息");
            return "{message:在parkingLOT表中没找到"+adp.getParkinglotID()+"的信息，请检查数据}";
        }
        LOG.warn("-------------正在创建车场------------");
        //此处用来创建停车场
        //对找到的信息进行签名

        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();
        map.put("parkName", pkl.getParkinglotName());
//        map.put("parkName", adp.getParkName());
//        map.put("status", adp.getStatus().toString());
        map.put("cityId", adp.getCityId());
        map.put("partnerId", ad.getPartnerId());

        String sign = anboECCSign.sign(map);
        LOG.warn("签名：" + sign);
        map.put("sign", sign);

        LOG.warn("签名后的需要提交的信息：" + map);

        String api = "park";

        JSONObject obj = httpconnect.doitpost(map, api);

        if (obj.get("status").equals("20000000")) {
            JSONObject object = obj.getJSONObject("result");
            LOG.warn("创建停车场获得的result：" + object.toString());
            System.out.println("获得的result中的parkID：" + object.get("parkId"));
            if (!object.isEmpty()) {
                Advertisement_Park adp01 = new Advertisement_Park();
                adp01.setParkId(object.get("parkId").toString());
                adp01.setPartnerId(object.get("partnerId").toString());
                adp01.setCityId(object.get("cityId").toString());
                adp01.setParkName(pkl.getParkinglotName());
                adp01.setStatus(1);
                adp01.setParkinglotID(adp.getParkinglotID());
                boolean tr = AdvertisementParkService.updateAdPark(adp01);
                LOG.warn("添加停车场返回的结果再返回给数据库是否成功：" + tr);
            }
            //通过返回最新的parkID再去找parkinglotID
            String ParkinglotID=AdvertisementParkService.findParkinglotIDbyparkId(object.get("parkId").toString());
            this.addADinfo(ParkinglotID);
            return obj.toString();
            }else{
            LOG.warn(obj.toString());
            return obj.get("message").toString();
        }
    }

    //    更新车场信息
    @RequestMapping(value = "/toupdatepark", method = RequestMethod.POST)
    @ResponseBody
    public String toupdatepark(String AdvertID,String parkId) throws Exception {
        //此处将要发送的数据转换为map格式
        LOG.warn("更新车场信息模块，开始通过广告主ID寻找信息...");
        Advertisement_Park ad = AdvertisementParkService.findparkbyAdvertIDandparkId(AdvertID,parkId);
        if (ad==null){
            return "更新车场模块----没找到该广告主下的停车场信息";
        }
        //感觉需要做额外的判断
        //对找到的信息进行签名
        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();
        map.put("parkName", ad.getParkName());
        map.put("status", ad.getStatus().toString());
        map.put("cityId", ad.getCityId());
        map.put("partnerId", ad.getPartnerId());
        String sign = anboECCSign.sign(map);
        LOG.warn("加密后的信息：" + sign);
        map.put("sign", sign);

        LOG.warn("加密后的需要提交的信息：" + map);

        String api = "park";

        JSONObject obj =httpconnect.doitput(map, api);

//        if (obj.get("status").equals("20000000")) {
//            JSONObject object = obj.getJSONObject("result");
//        }

        return obj.toString();
    }

    //    获取车场信息
    @RequestMapping(value = "/getpark", method = RequestMethod.POST)
    @ResponseBody
    public String getpark(String AdvertID,String parkId) throws Exception {
        //此处将要发送的数据转换为map格式
        Advertisement_Park ad = AdvertisementParkService.findparkbyAdvertIDandparkId(AdvertID,parkId);

        Map<String, String> map = new HashMap<>();
        map.put("parkId", ad.getParkId());
        map.put("partnerId", ad.getPartnerId());

        LOG.warn("需要提交的信息：" + map);

        String api = "park";

//        在这进行JSON格式中含数组的取值
        JSONObject obj = httpconnect.doitget(map, api);

        JSONArray object = obj.getJSONArray("result");

        LOG.warn("获取车场信息模块返回的结果集：" + object.toString());

        return obj.toString();
    }

    //    新增/更新广告位信息
    @RequestMapping(value = "/addADinfo", method = RequestMethod.POST)
    @ResponseBody
    public String addADinfo(String ParkinglotID) throws Exception {
        //此处将要发送的数据转换为map格式
        LOG.warn("开始通过车场ID寻找广告位信息进行新增..."+ParkinglotID);
        Advertisement_Park adp = AdvertisementParkService.findbyParkinglotID(ParkinglotID);

        if (adp==null){
            return "该停车场ID在数据库中没有广告位信息，请进行添加";
        }
        LOG.warn("新增广告位信息-----------开始通过本地车场ID寻找广告位信息...");
            //对找到的信息进行签名
            AnboECCSign anboECCSign = new AnboECCSign();
            Map<String, String> map = new HashMap<>();
            map.put("adPosIds", adp.getAdPosIds());
            map.put("status",adp.getStatus().toString());
            map.put("parkId", adp.getParkId());
            map.put("partnerId", adp.getPartnerId());
            String sign = anboECCSign.sign(map);
            map.put("sign", sign);

            LOG.warn("加密后的需要提交的信息：" + map);

            String api = "advert-pos";

            return httpconnect.doitput(map, api).toString();
        }

    //    获取广告位信息
    @RequestMapping(value = "/getADwinfo", method = RequestMethod.POST)
    @ResponseBody
    public String getADwinfo(String ParkinglotID) throws Exception {
        LOG.warn("开始通过停车场ID寻找信息...");
        Advertisement_Park adp = AdvertisementParkService.findbyParkinglotID(ParkinglotID);
        //此处将要发送的数据转换为map格式
        //对找到的信息进行签名
        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();

        map.put("parkId", adp.getParkId());
        map.put("partnerId", adp.getPartnerId());

        String api = "advert-pos";

        JSONObject obj = httpconnect.doitget(map, api);

        JSONObject object = obj.getJSONObject("result");
        //广告位名称
        String positionName = object.get("positionName").toString();
        LOG.warn("获取到的广告位名称：" + positionName);
        //获取到的广告形式
        String adType = object.get("adType").toString();
        LOG.warn("获取到的广告位名称：" + adType);

        return obj.toString();
    }

    //    获取广告
    @CrossOrigin
    @RequestMapping(value = "/v1/advert", method = RequestMethod.POST)
    @ResponseBody
    public String getAD(@RequestBody Advertisement_Park ad) throws Exception {
        System.out.println("接到的参数"+ad);

        //从接口接收parkID,adPosId,userMobile,userLicense
        //用接收到的parkID(其实是parkinglotID)去查partnerId和广告平台定义的parkID
        if(ad.getParkinglotID().equals("")){
            return "{message:不能输入空的停车场ID}";
        }
//        通过输入的parkinglotID去找平台生成的parkID
        String parkId = AdvertisementParkService.findparkIdbyParkinglotID(ad.getParkinglotID());
        if (parkId==null){
            LOG.warn("没找到与该停车场ID关联的广告平台的parkId");
        }
        //通过输入的parkinglotID去找平台生成的partnerId
        String partnerId = AdvertisementParkService.findpartnerIdbyparkId(parkId);
        if (partnerId==null){
            LOG.warn("没找到与该停车场ID关联的商户号");
        }
        //对找到的信息进行签名
        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();
        map.put("parkId", parkId);
        map.put("partnerId", partnerId);
        map.put("adPosId", ad.getAdPosIds());
        map.put("userMobile", ad.getUserMobile());
        map.put("userLicense", ad.getUserLicense());

        String sign = anboECCSign.sign(map);
        LOG.warn("签名：" + sign);
        map.put("sign", sign);

        LOG.warn("签名后的需要提交的信息：" + map);

        String api = "advert";

        JSONObject obj = httpconnect.doitget(map, api);

//        把获取到的广告url存到数据库
        JSONObject object = obj.getJSONObject("result");

        LOG.warn("获取到的广告信息：" + object.toString());

//        把获得的传到数据库
        if (!object.isEmpty()) {
            return obj.toString();
        } else {
            return obj.toString();
        }
    }

    //    广告跳转
    @CrossOrigin
    @RequestMapping(value = "/v1/advert/redirect", method = RequestMethod.GET)
    public String jumpAD(@RequestParam("ParkinglotID") String ParkinglotID,@RequestParam("adId") String adId) throws Exception {
        //此处将要发送的数据转换为map格式
        LOG.warn("从前端获得的消息" + ParkinglotID+adId);
        String parkId = AdvertisementParkService.findparkIdbyParkinglotID(ParkinglotID);
        String partnerId=AdvertisementParkService.findpartnerIdbyParkinglotID(ParkinglotID);
        if (parkId==null){
            return "{message:请输入正确的停车场ID}";
        }
        //对找到的信息进行签名
        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();
        map.put("parkId", parkId);
        map.put("adId", adId);
        map.put("partnerId", partnerId);
        String sign = anboECCSign.sign(map);
        map.put("sign", sign);

        String link="https://ad.anbokeji.net/api/v1/advert/redirect?"+"adId="+adId+"&partnerId="+partnerId+"&parkId="+parkId+"&sign="+sign;

        return link;
    }

}
