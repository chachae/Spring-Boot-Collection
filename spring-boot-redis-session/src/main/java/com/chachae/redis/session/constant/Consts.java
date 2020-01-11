package com.chachae.redis.session.constant;

import java.util.Arrays;
import java.util.List;

/**
 * 常量池
 *
 * @author chachae
 * @since 2020/1/11 14:34
 */
public class Consts {

  // session key
  public static final String SESSION_KEY = "session:token:";

  //  访问白名单
  public static final List<String> WHITE_API = Arrays.asList("/", "/login", "/page/login");
}
