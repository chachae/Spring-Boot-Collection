package com.chachae.ratelimiter.redis.annotation;

import java.lang.annotation.*;

/**
 * @author chachae
 * @since 2020/1/10 18:10
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RateLimiter {

  // 指定second 时间内 API请求次数（实际开发可将数字调整更大，适用于教务系统抢课限流)
  long counts() default 10L;

  // 请求次数的指定时间范围  秒数(redis数据过期时间，默认5秒)
  long second() default 5L;

  int NOT_LIMITED = 0;
}
