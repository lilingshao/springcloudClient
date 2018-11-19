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
    UserCloudServerFeign userclient;
    //服务端项目名
    @FeignClient(name = "mySpringcloudServer")
    interface UserCloudServerFeign {
        @RequestMapping(path = "/userList", method = RequestMethod.GET)
        @ResponseBody
        String userList(@RequestParam(required = true, value = "id") String id);

        @RequestMapping(path = "/user/2", method = RequestMethod.GET)
        @ResponseBody
        String getUserInfo();

        @RequestMapping(path = "/helloworld", method = RequestMethod.GET)
        @ResponseBody
        String HelloWorld();

        @RequestMapping(path = "/getUser", method = RequestMethod.GET)
        @ResponseBody
        List<User> getUser(@RequestParam(required = true, value = "id") String id);
    }
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

