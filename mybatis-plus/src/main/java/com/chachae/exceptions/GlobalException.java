package com.chachae.exceptions;

import com.chachae.bean.REnum;
import com.chachae.bean.Result;
import com.chachae.util.DateUtil;
import com.chachae.util.HttpContextUtil;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author chachae
 * @date 2019/12/19 19:13
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

  private Map<String, Object> errMap = Maps.newHashMap();
  private Date time = DateUtil.nowDate();

  @ExceptionHandler(ApiException.class)
  public Result<Map<String, Object>> apiException(ApiException e) {
    errMap = resolveException(e);
    return Result.fail(errMap, REnum.FAIL.value());
  }

  @ExceptionHandler(BindException.class)
  public Result<Map<String, Object>> bindException(BindException e) {
    errMap = resolveException(e);
    return Result.fail(errMap, REnum.FAIL.value());
  }

  @ExceptionHandler(Exception.class)
  public Result<Map<String, Object>> exception(Exception e) {
    errMap = resolveException(e);
    return Result.fail(errMap, REnum.SERVER_ERROR.value());
  }

  private Map<String, Object> resolveException(Exception e) {
    // 异常信息
    Object msg;
    // 循环索引
    Integer index = 1;
    // 获取触发异常的接口
    HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
    String uri = request.getRequestURI();

    // 处理异常类
    if (e instanceof ApiException) {
      msg = ((ApiException) e).getMsg();
    } else if (e instanceof BindException) {
      List<ObjectError> errs = ((BindException) e).getBindingResult().getAllErrors();
      Map<String, String> bindExceptionMap = Maps.newHashMap();
      for (ObjectError err : errs) {
        String k = ((FieldError) err).getField();
        String v = err.getDefaultMessage();
        bindExceptionMap.put(k, v);
      }
      msg = bindExceptionMap;
    } else {
      msg = e.getMessage();
    }

    // 处理异常日志信息
    if (!(e instanceof ApiException)) {
      for (StackTraceElement elem : e.getStackTrace()) {
        if (elem.getClassName().contains("com.chachae")) {
          log.error("{}:{}", index, elem.toString());
          index++;
        }
      }
    }

    // 输出返回异常日志
    errMap.put("msg", msg);
    errMap.put("api", uri);
    log.error("异常信息：{}", msg);
    log.error("异常接口：{}", uri);
    log.error("异常时间：{}", time);
    log.error("异常类：{}", e.getClass());
    return errMap;
  }
}
