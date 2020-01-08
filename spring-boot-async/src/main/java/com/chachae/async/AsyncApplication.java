package com.chachae.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author chachae
 * @since 2020/1/8 9:01
 */
@EnableAsync
@SpringBootApplication
public class AsyncApplication {

  public static void main(String[] args) {
    SpringApplication.run(AsyncApplication.class);
  }
}
