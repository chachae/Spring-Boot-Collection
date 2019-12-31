package com.chachae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chachae
 * @since 2019/12/31 14:18
 */
@Controller
public class ViewController {

  @GetMapping("/login")
  public String login() {
    return "/login";
  }
}
