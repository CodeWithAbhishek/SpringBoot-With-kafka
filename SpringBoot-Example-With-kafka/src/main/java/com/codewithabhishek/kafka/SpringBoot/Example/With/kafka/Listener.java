package com.codewithabhishek.kafka.SpringBoot.Example.With.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Listener {

    @KafkaListener(topics="code" , groupId = "group_id") //
    public void listen(String message){

       System.out.println("your message is " +message);

    }


}
