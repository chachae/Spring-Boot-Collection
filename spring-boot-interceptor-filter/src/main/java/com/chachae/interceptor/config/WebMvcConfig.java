package com.chachae.interceptor.config;

import com.chachae.interceptor.interceptor.HelloInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chachae
 * @since 2020/1/13 20:39
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  private static final String BASE_URI = "/**";

  @Autowired private HelloInterceptor helloInterceptor;

  /** 拦截器注册 */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(helloInterceptor).addPathPatterns(BASE_URI);
  }
}
