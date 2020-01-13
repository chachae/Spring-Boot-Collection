package com.chachae.interceptor.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 拦截器
 *
 * @author chachae
 * @since 2020/1/13 20:36
 */
@Component
public class HelloInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    String uri = request.getRequestURI();
    if (uri.contains("hi")) {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter writer = response.getWriter();
      writer.println("拦截器拦截包含【hi】的关键字接口成功");
      writer.flush();
      writer.close();
      return false;
    }
    return true;
  }
}
