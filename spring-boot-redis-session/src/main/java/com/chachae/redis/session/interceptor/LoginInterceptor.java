package com.chachae.redis.session.interceptor;

import cn.hutool.core.util.ObjectUtil;
import com.chachae.redis.session.constant.Consts;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author chachae
 * @since 2020/1/11 14:36
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    // 访问的API 和 session 信息
    String uri = request.getRequestURI();
    HttpSession session = request.getSession();

    // 访问白名单的uri 默认放行
    if (Consts.WHITE_API.contains(uri)) {
      return true;
    }

    // session 不为空默认放行
    if (ObjectUtil.isNotEmpty(session.getAttribute(Consts.SESSION_KEY))) {
      return true;
    }

    // 重定向到登录页
    response.sendRedirect(request.getContextPath() + "/page/login");
    return false;
  }

  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {}
}
