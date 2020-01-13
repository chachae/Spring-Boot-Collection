package com.chachae.interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * <a
 * href="https://github.com/Snailclimb/springboot-guide/blob/master/docs/basis/springboot-filter.md">Filter</a>
 *
 * @author chachae
 * @since 2020/1/13 17:50
 */

// 扫描@WebServlet 注解
@ServletComponentScan(basePackages = "com.chachae.interceptor")
@SpringBootApplication
public class InterceptorFilterApplication {

  public static void main(String[] args) {
    SpringApplication.run(InterceptorFilterApplication.class);
  }
}
