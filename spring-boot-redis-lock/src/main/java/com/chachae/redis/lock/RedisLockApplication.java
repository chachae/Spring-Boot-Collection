package com.chachae.redis.lock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chachae
 * @since 2020/1/11 21:10
 */
@SpringBootApplication
public class RedisLockApplication {

  public static void main(String[] args) {
    SpringApplication.run(RedisLockApplication.class, args);
  }
}
