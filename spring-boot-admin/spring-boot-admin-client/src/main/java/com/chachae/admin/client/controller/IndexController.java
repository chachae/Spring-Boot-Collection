package com.chachae.admin.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/1/11 12:18
 */
@RestController
public class IndexController {
  @GetMapping(value = {"", "/"})
  public String index() {
    return "This is a Spring Boot Admin Client.";
  }
}
