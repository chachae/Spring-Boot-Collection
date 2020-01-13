package com.chachae.interceptor.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author chachae
 * @since 2020/1/13 18:06
 */
@Slf4j
@Component
public class HelloFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) {
    log.info("{} 初始化成功", filterConfig.getFilterName());
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    log.info("Hello Filter ......");
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    log.info("Hello Filter 销毁");
  }
}
