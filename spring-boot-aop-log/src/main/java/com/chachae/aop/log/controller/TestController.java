package com.chachae.aop.log.controller;

import com.chachae.aop.log.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chachae
 * @since 2020/1/10 9:30
 */
@RestController
@RequestMapping("/log")
public class TestController {

  @Resource private LogService logService;

  @GetMapping("/{id}")
  public ResponseEntity<String> getLog(@PathVariable String id) {
    String res = this.logService.getLog(id);
    return ResponseEntity.ok(res);
  }
}
