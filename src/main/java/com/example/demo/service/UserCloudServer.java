package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class UserCloudServer{

    @Autowired
    UserFeignClient userclient;

    public String getUserInfo(){
        return "";
    }
    public String userList(String id){
        return "";
    }
    public List<User> getUser(String id){
        return userclient.getUser(id);
    }
    public String HelloWorld(){
        return "hello";
    }
}

