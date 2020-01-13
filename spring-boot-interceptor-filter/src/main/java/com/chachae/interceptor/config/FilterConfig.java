package com.chachae.interceptor.config;

import com.chachae.interceptor.filter.HelloFilter;
import com.chachae.interceptor.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author chachae
 * @since 2020/1/13 18:12
 */
@Configuration
public class FilterConfig {
  private static final String URI = "/*";

  @Resource private LogFilter logFilter;

  @Resource private HelloFilter helloFilter;

  @Bean
  public FilterRegistrationBean<LogFilter> logFilterReg() {
    FilterRegistrationBean<LogFilter> reg = new FilterRegistrationBean<>();
    reg.setFilter(logFilter);
    // 过滤顺序1
    reg.setOrder(1);
    reg.addUrlPatterns(URI);
    return reg;
  }

  @Bean
  public FilterRegistrationBean<HelloFilter> helloFilterReg() {
    FilterRegistrationBean<HelloFilter> reg = new FilterRegistrationBean<>();
    reg.setFilter(helloFilter);
    // 过滤顺序2
    reg.setOrder(2);
    reg.addUrlPatterns(URI);
    return reg;
  }
}
