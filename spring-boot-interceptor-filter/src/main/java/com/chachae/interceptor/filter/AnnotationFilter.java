package com.chachae.interceptor.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 使用注解的方式
 *
 * @author chachae
 * @since 2020/1/13 20:33
 */
@Slf4j
@WebFilter(filterName = "annotationFilter", urlPatterns = "/*")
public class AnnotationFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    log.info("Annotation Filter ......");
    chain.doFilter(request, response);
  }
}
