package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserFeignClientFailure implements UserFeignClient {
    @Override
    public String userList(String id) {
        return null;
    }

    @Override
    public String getUserInfo() {
        return null;
    }

    @Override
    public String HelloWorld() {
        return null;
    }

    @Override
    public List<User> getUser(String id) {
        User u = new User();u.setName("error...");
        List<User> list = new ArrayList<>();
        list.add(u);
        return list;
    }
}
