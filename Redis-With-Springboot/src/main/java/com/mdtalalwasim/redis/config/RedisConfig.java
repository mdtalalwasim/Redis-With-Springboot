package com.mdtalalwasim.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
	
	
	@Bean
	public RedisConnectionFactory connectionFactory() {
		
		return new LettuceConnectionFactory();
		
	}
	
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		
		//we will perform operations with out entity, model, thats why value is here Object.
		RedisTemplate<String, Object> redisTemplateObject = new RedisTemplate<>();
		
		
		redisTemplateObject.setConnectionFactory(connectionFactory());
		
		
		redisTemplateObject.setKeySerializer(new StringRedisSerializer());
		
		
		redisTemplateObject.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		
		return redisTemplateObject;
	}

}
