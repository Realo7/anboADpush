package com.hq.adpush;

import com.hq.adpush.controller.CreatAccount;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hq.adpush.dao")
public class AdpushApplication {
    static CreatAccount CreatAccount=new CreatAccount();

    public static void main(String[] args) throws Exception {

        SpringApplication.run(AdpushApplication.class, args);
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        System.out.println("程序正在运行...");
//        CreatAccount.tocreataccount("001");

    }

}
