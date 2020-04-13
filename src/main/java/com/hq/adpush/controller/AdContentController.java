package com.hq.adpush.controller;

import com.hq.adpush.entity.AdContent;
import com.hq.adpush.service.AdContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/adcontent")
public class AdContentController {
    @Autowired
    private AdContentService AdContentService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateAd(){
        System.out.println("开始更新advertisement...");

        AdContent ADC=new AdContent();
        ADC.setUserMobile("15977455");
        ADC.setParkId("PK0087");

        return AdContentService.updateAdConnect(ADC);
    }
}
