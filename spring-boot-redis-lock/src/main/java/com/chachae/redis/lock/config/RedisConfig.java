package com.chachae.redis.lock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @author chachae
 * @since 2020/1/11 21:13
 */
@Configuration
public class RedisConfig {

  /**
   * Redis 操作模板
   *
   * @param redisConnectionFactory LettuceConnectionFactory 连接
   * @return RedisTemplate
   */
  @Bean
  public RedisTemplate<String, Serializable> redisCacheTemplate(
      LettuceConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, Serializable> template = new RedisTemplate<>();
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    template.setConnectionFactory(redisConnectionFactory);
    return template;
  }
}
