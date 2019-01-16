package com.example.demo;

import com.example.demo.cloudBusKafka.KafkaSender;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//服务注册到ZK
@EnableDiscoveryClient
@MapperScan("com.example.demo.dao")
public class Application{

//	@Autowired
//	private KafkaSender kafkaSender;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
