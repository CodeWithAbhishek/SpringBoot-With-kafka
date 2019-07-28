package com.codewithabhishe.configuration;
/*
*
*
*     @CodeWithAbhishek
*
*

 */

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.errors.LeaderNotAvailableException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

import java.util.HashMap;

@Configuration
@EnableKafka
public class KakfaConfiguration {



    @Bean
    public ConsumerFactory<String,String> consumer(){

        Map<String , Object> configuartion = new HashMap<>();
        configuartion.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        configuartion.put(ConsumerConfig.GROUP_ID_CONFIG,"group_id");
        configuartion.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configuartion.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(configuartion);

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> containerFactory(){

        ConcurrentKafkaListenerContainerFactory<String , String> listener = new ConcurrentKafkaListenerContainerFactory();
        listener.setConsumerFactory(consumer());

   return listener;
    }



}
