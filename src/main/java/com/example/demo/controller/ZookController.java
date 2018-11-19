package com.example.demo.controller;

import java.util.List;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zook")
public class ZookController {
    @Autowired
    private DiscoveryClient client;
    @Autowired
    private Environment environment;
    @Value("${spring.datasource.username}")
    public String username ;
    @Value("${spring.redis.timeout}")
    public String stst ;

    /**
     * 功能链接
     * zk作为配置中心管理配置文件,可参考如下链接
     * https://blog.csdn.net/qq_2300688967/article/details/81267325
     * @return
     */
    @RequestMapping("/getZKconfig")
    public String getZook() {
    	System.out.println(this.username);//zk.txt文件中的值
    	System.out.println(this.stst);//redis文件中的值
        return username;
    }

    @RequestMapping("/getServices")
    public String discoveryClent() {
        List<String> serviceList = client.getServices();
        System.out.println("注册服务的数量>>>>>>>>>>>>>>>>>" + serviceList.size());
        for (String service : serviceList) {
            System.out.println("注册的服务>>>>>>" + service);
        }
        return "info";
    }

    @GetMapping("/env2")
    public String test2() {
    	//获取实例化的注册节点
        List<ServiceInstance> list = client.getInstances("CONSUL-CLIENT");

        //获取实例化的服务
        StringBuffer sb = new StringBuffer();
        if (list != null && list.size() > 0 ) {
            sb.append(list.get(0).getUri()+",");
        }
        return "hello world  "+sb.toString();

    }
    @GetMapping("/env")
    public String test() {
    	String[] profiles = environment.getActiveProfiles();
    	System.out.println("profiles>>>>>>>" + profiles.length);
    	for (String item : profiles) {
    		System.out.println("item>>>>>>>>>>>>>>>" + item);
    	}
    	
    	String name = environment.getProperty("url");
    	System.out.println(name);
    	
    	return "Hello," + name;
    }
}
