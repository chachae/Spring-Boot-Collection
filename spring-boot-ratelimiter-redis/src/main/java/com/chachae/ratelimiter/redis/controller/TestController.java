package com.chachae.ratelimiter.redis.controller;

import com.chachae.ratelimiter.redis.annotation.RateLimiter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/1/10 18:00
 */
@RestController
@RequestMapping("/rate")
public class TestController {

  @GetMapping("/on")
  @RateLimiter(counts = 5L, second = 10L)
  public ResponseEntity<String> onRateLimiter() {
    String msg = "测试限速";
    return ResponseEntity.ok(msg);
  }

  @GetMapping("/off")
  public ResponseEntity<String> offRateLimiter() {
    String msg = "无限速接口测试";
    return ResponseEntity.ok(msg);
  }
}
