package com.chachae.interceptor.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author chachae
 * @since 2020/1/13 17:58
 */
@Slf4j
@Component
public class LogFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) {
    log.info("{} 初始化成功", filterConfig.getFilterName());
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    long start = System.currentTimeMillis();
    HttpServletRequest req = (HttpServletRequest) request;
    String uri = req.getRequestURI();
    chain.doFilter(request, response);
    long end = System.currentTimeMillis();
    log.info("【请求接口】：{}", uri);
    log.info("【请求耗时】：{} ms", (end - start));
  }

  @Override
  public void destroy() {
    log.info("销毁Log Filter 过滤器");
  }
}
