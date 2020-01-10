package com.chachae.ratelimiter.redis.aspect;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.StrUtil;
import com.chachae.ratelimiter.redis.annotation.RateLimiter;
import com.chachae.ratelimiter.redis.constant.Consts;
import com.chachae.ratelimiter.redis.util.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Redis 限流切面
 *
 * @author chachae
 * @since 2020/1/10 19:56
 */
@Aspect
@Slf4j
@Component
public class RateLimiterAspect {

  private static final Integer INIT_COUNT = 1;

  @Resource private RedisTemplate<String, Integer> redisTemplate;

  @Pointcut("@annotation(com.chachae.ratelimiter.redis.annotation.RateLimiter)")
  public void rateLimit() {}

  @Around("rateLimit()")
  public Object point(ProceedingJoinPoint point) throws Throwable {

    MethodSignature signature = (MethodSignature) point.getSignature();
    Method method = signature.getMethod();
    RateLimiter rateLimiter = AnnotationUtils.findAnnotation(method, RateLimiter.class);
    // 存在限流注解且限制访问次数不等于0
    if (rateLimiter != null && rateLimiter.counts() != RateLimiter.NOT_LIMITED) {
      // 获取限流次数
      long counts = rateLimiter.counts();
      long times = rateLimiter.second();
      // 尝试从redis 中获取限流信息，key 的包装方法使用getkey() 方法进行包装
      String key = getKey(method);
      Integer value = redisTemplate.opsForValue().get(key);
      // 存在则对value 进行处理
      if (value == null) {
        // 初始化接口限流数据比持久化到redis 中
        value = INIT_COUNT;
        redisTemplate.opsForValue().set(key, value, times, TimeUnit.SECONDS);
      }
      if (value >= counts) {
        throw new RuntimeException("访问过于频繁，请稍后重试！");
      }
      // 更新数据，设置偏移量为0，不更新时间
      value++;
      redisTemplate.opsForValue().set(key, value, 0);
    }
    return point.proceed();
  }

  /** 组装key */
  private String getKey(Method method) {
    // RATE_LIMIT_PREFIX + IP + 方法名
    StringBuilder res = new StringBuilder();
    String name = method.getName();
    String ip = IPUtil.getIpAddr();
    // ip 转long
    long ipv4Long = NetUtil.ipv4ToLong(ip);
    return res.append(Consts.RATE_LIMIT_PREFIX)
        .append(ipv4Long)
        .append(StrUtil.UNDERLINE)
        .append(name)
        .toString();
  }
}
