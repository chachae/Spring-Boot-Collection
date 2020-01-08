package com.chachae.exceptions;

import com.google.common.collect.Maps;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 全局异常处理
 *
 * @author chachae
 * @since 2020/1/7 23:29
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  private Map<String, Object> resMap = Maps.newHashMap();

  /**
   * 处理运行时异常
   *
   * @param e 异常
   * @param request 前台请求
   * @return 返回异常信息
   */
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Map<String, Object>> handlerRuntimeException(
      RuntimeException e, HttpServletRequest request) {
    resMap.put("msg", e.getMessage());
    resMap.put("url", request.getRequestURI());
    return ResponseEntity.ok(resMap);
  }

  /**
   * 处理Exception 异常
   *
   * @param e 异常
   * @param request 前台请求
   * @return 返回异常信息
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handlerException(
      Exception e, HttpServletRequest request) {
    resMap.put("msg", e.getMessage());
    resMap.put("url", request.getRequestURI());
    return ResponseEntity.ok(resMap);
  }
}
