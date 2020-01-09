package com.chachae.exception.handler.controller;

import com.chachae.exception.handler.exceptions.ApiException;
import com.chachae.exception.handler.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/1/9 10:06
 */
@RestController
@RequestMapping("/exception")
public class TestController {

  @GetMapping("/success/{arg}")
  public Result<String> ok(@PathVariable String arg) {
    return Result.ok(arg);
  }

  @GetMapping("/fail/{arg}")
  public Result<String> fail(@PathVariable String arg) {
    try {
      int a = Integer.parseInt(arg) / 0;
    } catch (Exception ignored) {
      throw ApiException.argError("异常测试");
    }
    return Result.ok(arg);
  }
}
