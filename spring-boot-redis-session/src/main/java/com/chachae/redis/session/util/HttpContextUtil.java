package com.chachae.redis.session.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author chachae
 * @since 2019/12/21 11:02
 */
public class HttpContextUtil {

  private HttpContextUtil() {}

  public static HttpServletRequest getHttpServletRequest() {
    return ((ServletRequestAttributes)
            Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
        .getRequest();
  }

  /**
   * 设置session
   *
   * @param attribute session 名
   * @param obj session 内容.
   */
  public static void setSession(String attribute, Object obj) {
    Objects.requireNonNull(RequestContextHolder.getRequestAttributes())
        .setAttribute(attribute, obj, RequestAttributes.SCOPE_SESSION);
  }

  /**
   * 获取session
   *
   * @param attribute session 名
   * @return session 内容.
   */
  public static Object getSession(String attribute) {
    return Objects.requireNonNull(RequestContextHolder.getRequestAttributes())
        .getAttribute(attribute, RequestAttributes.SCOPE_SESSION);
  }

  /**
   * 移除session
   *
   * @param attribute session 名.
   */
  public static void removeSession(String attribute) {
    Objects.requireNonNull(RequestContextHolder.getRequestAttributes())
        .removeAttribute(attribute, RequestAttributes.SCOPE_SESSION);
  }
}
