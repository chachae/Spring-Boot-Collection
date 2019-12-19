package com.chachae.controller;

import com.chachae.exceptions.ApiException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @date 2019/12/19 19:26
 */
@RestController
@RequestMapping("/test")
public class TestController {

  @GetMapping("/exception")
  public void exception(String args) {
    try {
      int a = Integer.valueOf(args) / 0;
    } catch (Exception e) {
      throw ApiException.argError("参数异常");
    }
  }
}
