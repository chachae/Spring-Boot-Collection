package com.chachae.ratelimiter.guava.aspect;

import com.chachae.ratelimiter.guava.annotation.Limit;
import com.google.common.util.concurrent.RateLimiter;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

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

  private static final ConcurrentMap<String, RateLimiter> LIMIT_MAP = new ConcurrentHashMap<>();

  @Pointcut("@annotation(com.chachae.ratelimiter.guava.annotation.Limit)")
  public void rateLimit() {}

  @Around("rateLimit()")
  public Object point(ProceedingJoinPoint point) throws Throwable {
    MethodSignature signature = (MethodSignature) point.getSignature();
    Method method = signature.getMethod();
    Limit limit = AnnotationUtils.findAnnotation(method, Limit.class);

    if (limit != null && limit.qps() > Limit.NOT_LIMITED) {
      if (LIMIT_MAP.get(method.getName()) == null) {
        LIMIT_MAP.put(method.getName(),
            RateLimiter.create(limit.qps(), limit.timeout(), limit.timeUnit()));
      }
      if (LIMIT_MAP.get(method.getName()) != null && !LIMIT_MAP.get(method.getName())
          .tryAcquire(limit.timeout(), limit.timeUnit())) {
        throw new RuntimeException("手速太快！");
      }
    }
    return point.proceed();
  }

}
