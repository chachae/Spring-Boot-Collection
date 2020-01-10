package com.chachae.ratelimiter.redis.util;

import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chachae
 * @since 2020/1/10 18:00
 */
@Slf4j
public class IPUtil {

  private static final String UNKNOWN = "unknown";

  private IPUtil() {}

  public static String getIpAddr() {
    HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
    String ip = request.getHeader("x-forwarded-for");
    if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
  }
}
