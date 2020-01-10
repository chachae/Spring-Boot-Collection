package com.chachae.ratelimiter.guava.controller;

import com.chachae.ratelimiter.guava.annotation.RateLimiter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/1/10 14:07
 */
@RestController
@RequestMapping("/rate")
public class TestController {

  @GetMapping("/off")
  public ResponseEntity<String> noRateLimit() {
    String msg = "本接口不做限流处理。";
    return ResponseEntity.ok(msg);
  }

  @GetMapping("/on")
  @RateLimiter(value = 2,timeout = 300)
  public ResponseEntity<String> onRateLimit() {
    String msg = "本接口限流，qps=2";
    return ResponseEntity.ok(msg);
  }
}
