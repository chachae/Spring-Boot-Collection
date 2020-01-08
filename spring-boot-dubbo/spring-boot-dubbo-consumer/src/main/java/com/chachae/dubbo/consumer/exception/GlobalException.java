package com.chachae.dubbo.consumer.exception;

import cn.hutool.core.lang.Dict;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author chachae
 * @since 2020/1/8 18:24
 */
@RestControllerAdvice
public class GlobalException {

  private static Map<String, Object> map = Maps.newHashMap();

  @ExceptionHandler(RuntimeException.class)
  public Map<String, Object> handlerException(RuntimeException e, HttpServletRequest req) {
    return Dict.create().set("api", req.getRequestURI()).set("msg", e.getMessage());
  }
}
