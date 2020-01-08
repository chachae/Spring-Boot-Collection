package com.chachae.actuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/1/8 15:48
 */
@RestController
@RequestMapping("/index")
public class IndexController {

  @GetMapping("/get/{arg}")
  public String get(@PathVariable Long arg) {
    return String.valueOf(arg);
  }
}
