package com.chachae.ratelimiter.redis.util;

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
}
