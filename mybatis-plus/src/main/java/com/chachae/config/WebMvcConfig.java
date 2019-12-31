package com.chachae.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chachae
 * @since 2019/12/31 11:53
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

  @Bean
  public RequestContextListener requestContextListener() {
    return new RequestContextListener();
  }

  private CorsConfiguration buildConfig() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    // 允许任何域名使用
    corsConfiguration.addAllowedOrigin("*");
    // 允许任何头
    corsConfiguration.addAllowedHeader("*");
    // 允许任何方法（post、get等）
    corsConfiguration.addAllowedMethod("*");
    return corsConfiguration;
  }
}
