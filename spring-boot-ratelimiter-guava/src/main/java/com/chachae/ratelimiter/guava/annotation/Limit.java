package com.chachae.ratelimiter.guava.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 限流注解，添加了 {@link AliasFor} 必须通过 {@link AnnotationUtils} 获取，才会生效
 *
 * <p>qps:Queries Per Second意思是“每秒查询率”
 *
 * @author chachae
 * @since 2020/1/10 11:58
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Limit {

  int NOT_LIMITED = 0;

  /**
   * qps
   */
  @AliasFor("qps")
  double value() default NOT_LIMITED;

  /**
   * qps
   */
  @AliasFor("value")
  double qps() default NOT_LIMITED;

  /**
   * 超时时长
   */
  int timeout() default 0;

  /**
   * 超时时间单位
   */
  TimeUnit timeUnit() default TimeUnit.SECONDS;


}
