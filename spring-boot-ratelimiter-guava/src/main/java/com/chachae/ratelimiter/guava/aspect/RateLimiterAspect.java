package com.chachae.ratelimiter.guava.aspect;

import com.chachae.ratelimiter.guava.annotation.RateLimiter;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 基于Guava 令牌桶限流切面
 *
 * @author chachae
 * @since 2020/1/10 16:32
 */
@Slf4j
@Component
@Aspect
public class RateLimiterAspect {

  private static final Map<String, com.google.common.util.concurrent.RateLimiter>
      RATE_LIMITER_CACHE = Maps.newConcurrentMap();

  @Pointcut("@annotation(com.chachae.ratelimiter.guava.annotation.RateLimiter)")
  public void rateLimit() {}

  @Around("rateLimit()")
  public Object point(ProceedingJoinPoint point) throws Throwable {
    MethodSignature signature = (MethodSignature) point.getSignature();
    Method method = signature.getMethod();
    String methodName = method.getName();
    // 尝试获取方法上的 RateLimiter注解
    RateLimiter rateLimiter = AnnotationUtils.findAnnotation(method, RateLimiter.class);
    if (rateLimiter != null && rateLimiter.qps() > RateLimiter.NOT_LIMITED) {
      double qps = rateLimiter.qps();
      if (RATE_LIMITER_CACHE.get(methodName) == null) {
        // 初始化令牌
        RATE_LIMITER_CACHE.put(
            methodName, com.google.common.util.concurrent.RateLimiter.create(qps));
        /* 尝试获取令牌
        tryAcquire(long timeout, TimeUnit unit)
        从RateLimiter 获取许可如果该许可可以在不超过timeout的时间内获取得到的话，或者如果无法在timeout
        过期之前获取得到许可的话，那么立即返回false（无需等待）
          */
        if (RATE_LIMITER_CACHE.get(method.getName()) != null
            && !RATE_LIMITER_CACHE
                .get(method.getName())
                .tryAcquire(rateLimiter.timeout(), rateLimiter.timeUnit())) {
          throw new RuntimeException("手速太快了，慢点儿吧~");
        }
      }
    }
    return point.proceed();
  }
}
