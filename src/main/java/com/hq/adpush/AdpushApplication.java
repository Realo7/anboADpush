package com.hq.adpush;

import com.hq.adpush.controller.CreatAccount;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdpushApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(AdpushApplication.class, args);
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        System.out.println("程序正在运行...");

    }

}
