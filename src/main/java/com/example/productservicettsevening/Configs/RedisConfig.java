package com.example.productservicettsevening.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

//@Configuration
//public class RedisConfig {
//
//    @Bean
//    RedisTemplate<Long,Object>redisTemplate(RedisConnectionFactory redisConnectionFactory){
//        RedisTemplate<Long, Object>template=new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }
//}
