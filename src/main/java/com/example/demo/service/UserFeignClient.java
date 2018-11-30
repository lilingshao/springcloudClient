package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
//服务端项目名-和-断路器
@FeignClient(name = "mySpringcloudServer",fallback = UserFeignClientFailure.class)
public interface UserFeignClient {

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
