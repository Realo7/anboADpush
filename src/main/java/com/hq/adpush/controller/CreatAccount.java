package com.hq.adpush.controller;

import com.alibaba.fastjson.JSONObject;
import com.hq.adpush.entity.AdContent;
import com.hq.adpush.entity.Advertisement;
import com.hq.adpush.entity.Advertisement_Park;
import com.hq.adpush.service.AdContentService;
import com.hq.adpush.service.AdService;
import com.hq.adpush.service.AdvertisementParkService;
import com.hq.adpush.util.restnet;
import com.zzrb.ecc.AnboECCSign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    //    JSONObject obj = new JSONObject();
    //新建一个账户
    @RequestMapping(value = "/tocreataccount", method = RequestMethod.POST)
    @ResponseBody
    public String tocreataccount(String AdvertID) throws Exception {
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
        map.put("password", ad.getPassword());
        map.put("publicKey", ad.getPublicKey());
        String sign = anboECCSign.sign(map);
        System.out.println("加密后的信息：" + sign);
        map.put("sign", sign);

        System.out.println("加密后的需要提交的信息：" + map);

        String api = "account";

//        doitpost(map,api);
        return doitpost(map, api).toString();
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
        map.put("password", ad.getPassword());
        map.put("publicKey", ad.getPublicKey());
        String sign = anboECCSign.sign(map);
        System.out.println("加密后的信息：" + sign);
        map.put("sign", sign);

        System.out.println("加密后的需要提交的信息：" + map);

        String api = "account";

//        doitpost(map,api);
        return doitput(map, api).toString();
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
        map.put("partnerId", ad.getParkName());


        String sign = anboECCSign.sign(map);
        System.out.println("加密后的信息：" + sign);
        map.put("sign", sign);

        System.out.println("加密后的需要提交的信息：" + map);

        String api = "park";

//        doitpost(map,api);
        return doitpost(map, api).toString();
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
        return doitput(map, api).toString();
    }

    //    获取车场信息
    @RequestMapping(value = "/getpark", method = RequestMethod.POST)
    @ResponseBody
    public String getpark(String AdvertID) throws Exception {
        //此处将要发送的数据转换为map格式
        Advertisement_Park ad = AdvertisementParkService.findparkbyAdvertID(AdvertID);
        //此处用来创建账户
        //对找到的信息进行签名
        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();
        map.put("parkId", ad.getParkId());
        map.put("partnerId", ad.getAdvertID());

        String sign = anboECCSign.sign(map);
        System.out.println("加密后的信息：" + sign);
        map.put("sign", sign);

        System.out.println("加密后的需要提交的信息：" + map);

        String api = "park";

//        doitpost(map,api);
        return doitget(map, api).toString();
    }

//    新增/更新广告位信息
@RequestMapping(value = "/addADinfo", method = RequestMethod.POST)
@ResponseBody
public String addADinfo(String parkId) throws Exception {
    //此处将要发送的数据转换为map格式
    System.out.println("开始通过广告主ID寻找信息...");
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
    return doitput(map, api).toString();
}

    //    获取广告位信息
    @RequestMapping(value = "/getADwinfo", method = RequestMethod.POST)
    @ResponseBody
    public String getADwinfo(String parkId) throws Exception {
        //此处将要发送的数据转换为map格式
        System.out.println("开始通过广告主ID寻找信息...");
        AdContent ad = AdContentService.findbyparkId(parkId);
        //此处用来创建账户
        //对找到的信息进行签名
        AnboECCSign anboECCSign = new AnboECCSign();
        Map<String, String> map = new HashMap<>();

        map.put("parkId", ad.getParkId());
        map.put("partnerId", ad.getPartnerId());

        String api = "advert-pos";

//        doitpost(map,api);
        return doitget(map, api).toString();
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
        System.out.println("加密后的信息：" + sign);
        map.put("sign", sign);

        System.out.println("加密后的需要提交的信息：" + map);

        String api = "advert";

//        doitpost(map,api);
        return doitget(map, api).toString();
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
        return doitget(map, api).toString();
    }



    //    把网络通信写个公共方法，稍后封装
    public JSONObject doitpost(Map<String, String> map, String api) {
        RestTemplate restTemplate = new RestTemplate();
        //请求地址
        String url = "http://118.178.56.187:8080/api/v1/" + api;
        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);//设置参数类型和编码
        headers.add("Uni-Source", "商户ID");
        //入参request
        HttpEntity<Map<String, String>> request = new HttpEntity<>(map, headers);//包装到HttpEntity
        ResponseEntity<JSONObject> response = restTemplate.postForEntity(url, request, JSONObject.class);
        System.out.println("post获得的参数" + response.getBody());

        return response.getBody();
    }

    //get方法
    public JSONObject doitget(Map<String, String> map, String api) {
        RestTemplate restTemplate = new RestTemplate();
        //请求地址
        String url = "http://118.178.56.187:8080/api/v1/" + api;
        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);//设置参数类型和编码
        headers.add("Uni-Source", "商户ID");
        //入参request
        HttpEntity<Map<String, String>> request = new HttpEntity<>(map, headers);//包装到HttpEntity
        ResponseEntity<JSONObject> response = restTemplate.exchange(url,HttpMethod.GET,request,JSONObject.class);
        System.out.println("get");
        System.out.println("get获得的参数" + response.getBody());

        return response.getBody();
    }

    //put方法
    public JSONObject doitput(Map<String, String> map, String api) {
        RestTemplate restTemplate = new RestTemplate();
        //请求地址
        String url = "http://118.178.56.187:8080/api/v1/" + api;
        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);//设置参数类型和编码
        headers.add("Uni-Source", "商户ID");
        //入参request
        HttpEntity<Map<String, String>> request = new HttpEntity<>(map, headers);//包装到HttpEntity
        ResponseEntity<JSONObject> response = restTemplate.exchange(url, HttpMethod.PUT, request, JSONObject.class);

        System.out.println("put获得的参数" + response.getBody());

        return response.getBody();
    }
}
