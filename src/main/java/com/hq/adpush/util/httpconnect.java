package com.hq.adpush.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

public class httpconnect {

    //    把网络通信写个公共方法，稍后封装
    public static JSONObject doitpost(Map<String, String> map, String api) {
        RestTemplate restTemplate = new RestTemplate();

        //请求地址
        String url = "https://api.anbokeji.net/api/v1/" + api;
        // 设置请求头
        String part = map.get("partnerId");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);//设置参数类型和编码
        headers.add("Uni-Source", part);
        //入参request
        HttpEntity<Map<String, String>> request = new HttpEntity<>(map, headers);//包装到HttpEntity

        ResponseEntity<JSONObject> response = restTemplate.postForEntity(url, request, JSONObject.class);

        System.out.println("post获得的参数" + response.getBody());

        return response.getBody();
    }

    //get方法
    public static JSONObject doitget(Map<String, String> map, String api) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new restnet.HttpComponentsClientRestfulHttpRequestFactory());
        //请求地址
        String url = "https://api.anbokeji.net/api/v1/" + api;

        System.out.println("get提交的map" + map);
        // 设置请求头
        String part = map.get("partnerId");
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);//设置参数类型和编码
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Uni-Source", part);

        //入参request
        HttpEntity<Map<String, String>> request = new HttpEntity<>(map, headers);//包装到HttpEntity

        ResponseEntity<JSONObject> response= restTemplate.exchange(url, HttpMethod.GET, request, JSONObject.class);


        System.out.println("get获得的参数" + response.getBody());

        return response.getBody();
    }

    //put方法
    public static JSONObject doitput(Map<String, String> map, String api) {
        RestTemplate restTemplate = new RestTemplate();
        //请求地址
        String url = "https://api.anbokeji.net/api/v1/" + api;
        // 设置请求头
        String part = map.get("partnerId");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);//设置参数类型和编码
        headers.add("Uni-Source", part);
        //入参request
        HttpEntity<Map<String, String>> request = new HttpEntity<>(map, headers);//包装到HttpEntity
        ResponseEntity<JSONObject> response = restTemplate.exchange(url, HttpMethod.PUT, request, JSONObject.class);

        System.out.println("put获得的参数" + response.getBody());

        return response.getBody();
    }

}
