package com.chachae.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chachae
 * @since 2020/1/8 17:16
 */
@SpringBootApplication
@EnableDubboConfig
public class ProviderApplication {
  public static void main(String[] args) {
    SpringApplication.run(ProviderApplication.class);
  }
}
