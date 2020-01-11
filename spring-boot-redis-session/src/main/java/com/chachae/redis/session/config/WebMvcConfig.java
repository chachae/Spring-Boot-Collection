package com.chachae.redis.session.config;

import com.chachae.redis.session.constant.Consts;
import com.chachae.redis.session.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author chachae
 * @since 2020/1/11 14:35
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Resource private LoginInterceptor loginInterceptor;

  /** 拦截器注册 */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addInterceptor(loginInterceptor)
        .excludePathPatterns(Consts.WHITE_API)
        .addPathPatterns("/**");
  }
}
