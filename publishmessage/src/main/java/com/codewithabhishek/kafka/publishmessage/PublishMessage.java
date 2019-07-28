package com.codewithabhishek.kafka.publishmessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class PublishMessage {

    @Autowired
    KafkaTemplate<String , String> Kt;

    private String publishtext="Spring Boot application With kafka";

    private final String  topic = "sendmessage";
    @RequestMapping("/send")
    public String publishmessage(){


        Kt.send(topic, publishtext);
        return "Message has been Publish successfully" + "              " +" Your Message is " +publishtext;
    }


}
