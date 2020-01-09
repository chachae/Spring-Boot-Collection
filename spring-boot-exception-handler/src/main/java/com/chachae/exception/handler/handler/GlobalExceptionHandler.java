package com.chachae.exception.handler.handler;

import com.chachae.exception.handler.exceptions.ApiException;
import com.chachae.exception.handler.model.Result;
import com.chachae.exception.handler.util.HttpContextUtil;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

/**
 * @author chachae
 * @since 2020/1/9 9:09
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  private static Map<String, Object> errMap = Maps.newHashMap();

  /**
   * ApiException
   *
   * @param e 异常
   * @return Result
   */
  @ExceptionHandler(ApiException.class)
  public Result<Map<String, Object>> apiException(ApiException e) {
    String uri = HttpContextUtil.getHttpServletRequest().getRequestURI();
    errMap.put("api", uri);
    errMap.put("msg", e.getMsg());
    return Result.fail(errMap);
  }

  /**
   * Validator Bind Exception
   *
   * @param e 异常
   * @return Result
   */
  @ExceptionHandler(BindException.class)
  public Result<Map<String, Object>> bindException(BindException e) {

    // 处理Bind Exception 的异常消息，需要配合validator 注解使用
    List<ObjectError> errs = e.getBindingResult().getAllErrors();
    Map<String, String> msgMap = Maps.newHashMap();
    for (ObjectError err : errs) {
      String k = ((FieldError) err).getField();
      String v = err.getDefaultMessage();
      msgMap.put(k, v);
    }

    String uri = HttpContextUtil.getHttpServletRequest().getRequestURI();
    errMap.put("api", uri);
    errMap.put("msg", msgMap);
    return Result.fail(errMap);
  }

  /**
   * Exception
   *
   * @param e 异常
   * @return Result
   */
  @ExceptionHandler(Exception.class)
  public Result<Map<String, Object>> exception(Exception e) {
    String uri = HttpContextUtil.getHttpServletRequest().getRequestURI();
    errMap.put("api", uri);
    errMap.put("msg", e.getMessage());
    return Result.fail(errMap);
  }
}
