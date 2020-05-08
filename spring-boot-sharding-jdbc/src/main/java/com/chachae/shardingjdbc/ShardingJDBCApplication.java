package com.chachae.shardingjdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author chachae
 * @since 2020/5/8 16:53
 */

@EnableTransactionManagement
@MapperScan("com.chachae.shardingjdbc.mapper")
@SpringBootApplication
public class ShardingJDBCApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShardingJDBCApplication.class, args);
  }

}
