package com.chachae.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author chachae
 * @date 2019/12/16 19:30
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.chachae.dao")
public class MyBatisPlusConfig {

  /**
   * 分页插件配置
   *
   * @return 分页插件对象
   */
  @Bean
  public PaginationInterceptor paginationInterceptor() {
    return new PaginationInterceptor();
  }
}
