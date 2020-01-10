package com.chachae.ratelimiter.guava.handler;

import cn.hutool.core.lang.Dict;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author chachae
 * @since 2020/1/10 12:03
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(RuntimeException.class)
  public Dict handlerRuntimeException(RuntimeException e) {
    return Dict.create().set("msg", e.getMessage());
  }
}
