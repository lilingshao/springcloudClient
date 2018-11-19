package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserCloudServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Bean;

import java.util.List;

@RestController
public class CloudController {
	@Autowired
    private UserCloudServer helloWorldClient;
	
	// PathVariable
	@RequestMapping("/user/{id}")
	public Bean getUserInfo(@PathVariable("id") String id) {
		Bean bean = new Bean();
		bean.setLikes("Orange");
		bean.setName("lili");
		bean.setId(id);
		return bean;
	}
	// Path
	@RequestMapping
	public Bean getUserList(@RequestParam(required = true, value = "id") String id) {
		Bean bean = new Bean();
		bean.setLikes("Banana");
		bean.setName("Mr Wang");
		bean.setId(id);
		return bean;
	}
	
    @GetMapping("/get-greeting")
    public String greeting() {
        return helloWorldClient.HelloWorld();
    }
    @GetMapping("/getuser")
    public String getUserInfo() {
    	return helloWorldClient.getUserInfo();
    }
    /**
     * 带参数的cloud服务
     * @param id
     * @return
     */
    @RequestMapping("/userList")
    public String userList(@RequestParam(required = true, value = "id") String id) {
    	return helloWorldClient.userList(id);
    }
    @RequestMapping(value="/getUser",method = {RequestMethod.GET})
    public List<User> getUser(@RequestParam(required = true, value = "id") String id) {
		return helloWorldClient.getUser(id);
	}
}
