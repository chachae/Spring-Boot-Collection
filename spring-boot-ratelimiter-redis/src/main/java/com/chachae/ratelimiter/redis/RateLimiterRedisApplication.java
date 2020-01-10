package com.chachae.ratelimiter.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chachae
 * @since 2020/1/10 17:58
 */
@SpringBootApplication
public class RateLimiterRedisApplication {

  public static void main(String[] args) {
    SpringApplication.run(RateLimiterRedisApplication.class);
  }
}
