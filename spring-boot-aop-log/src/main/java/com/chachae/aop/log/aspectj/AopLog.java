package com.chachae.aop.log.aspectj;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import cn.hutool.json.JSONUtil;
import com.chachae.aop.log.util.HttpContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 在真实项目中可使用数据库存储用户请求数据
 *
 * @author chachae
 * @since 2020/1/10 9:34
 */
@Slf4j
@Aspect
@Component
public class AopLog {

  private static final String START_TIME = "request-start-time";

  @Pointcut("execution(public * com.chachae.aop.log.service..*.*(..))")
  public void log() {}

  /**
   * 前置通知
   *
   * @param point point切入点，包含切面信息对象
   */
  @Before("log()")
  public void beforeLog(JoinPoint point) {
    // 请求 URL、请求 IP、请求类名、请求方法名、请求参数
    HttpServletRequest request = HttpContextUtil.getRequest();
    // 接口请求开始时间，用于计算接口请求耗时
    request.setAttribute(START_TIME, System.currentTimeMillis());
    Signature signature = point.getSignature();
    MethodSignature methodSignature = (MethodSignature) signature;
    String uri = request.getRequestURI();
    String ip = request.getRemoteAddr();
    Method method = methodSignature.getMethod();
    Map<String, String[]> params = request.getParameterMap();
    log.info("【请求接口】：{}", uri);
    log.info("【请求 IP】：{}", ip);
    log.info("【请求方法】：{}", method.toString());
    log.info("【请求参数】：{}", JSONUtil.toJsonStr(params));
  }

  /**
   * 环绕通知
   *
   * @param point 切入点
   * @return 接口请求返回数据
   */
  @Around("log()")
  public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
    Object res = point.proceed();
    log.info("【返回值】：{}", JSONUtil.toJsonStr(res));
    return res;
  }

  /** 后置通知 */
  @After("log()")
  public void afterLog() {
    // 接口请求耗时，userAgent 信息解析
    HttpServletRequest request = HttpContextUtil.getRequest();
    Long startTime = (Long) request.getAttribute(START_TIME);
    Long endTime = System.currentTimeMillis();
    String userAgent = request.getHeader("User-Agent");
    UserAgent parse = UserAgentUtil.parse(userAgent);
    String browser = parse.getBrowser().toString();
    String os = parse.getOs().toString();
    log.info("【请求耗时】：{} 毫秒", endTime - startTime);
    log.info("浏览器：{}，操作系统：{}，原始User-Agent：{}", browser, os, JSONUtil.toJsonStr(userAgent));
  }
}
