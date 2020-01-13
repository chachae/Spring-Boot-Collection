package com.chachae.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/1/13 17:53
 */
@RestController
public class TestController {

  @GetMapping("/hello/{name}")
  public String hello(@PathVariable String name) {
    return "Hello " + name;
  }

  @GetMapping("/hi/{name}")
  public String hi(@PathVariable String name) {
    return "Hi " + name;
  }
}
