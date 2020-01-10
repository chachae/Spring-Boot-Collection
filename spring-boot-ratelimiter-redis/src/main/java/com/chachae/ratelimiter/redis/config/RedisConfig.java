package com.chachae.ratelimiter.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @author chachae
 * @since 2020/1/10 18:03
 */
@Slf4j
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig {

  /**
   * Redis 操作模板
   *
   * @param redisConnectionFactory LettuceConnectionFactory 连接
   * @return RedisTemplate
   */
  @Bean
  public RedisTemplate<String, Serializable> redisTemplate(
      LettuceConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, Serializable> template = new RedisTemplate<>();
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    template.setConnectionFactory(redisConnectionFactory);
    return template;
  }
}
