package com.example.demo.cloudBusKafka;

import com.example.demo.cloudBusKafka.bean.Message;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@Slf4j
public class KafkaSender {
//    @Autowired
//    public KafkaTemplate<String,String> kafkaTemplate;
//    private Gson gson = new GsonBuilder().create();
//
//    @RequestMapping(value="sendTest",method = { RequestMethod.POST,RequestMethod.GET })
//    public void send(@RequestParam(required = true, value = "id") long id) {
//        Message message = new Message();
//        message.setId(id);
//        message.setMsg(UUID.randomUUID().toString());
//        message.setSendTime(new Date());
//        log.info("========发送消息  >>>>{}<<<<<==========",gson.toJson(message));
//        kafkaTemplate.send("wqh",gson.toJson(message));
//    }
}
