package com.chachae.dubbo.consumer.controller;

import com.chachae.dubbo.api.entity.User;
import com.chachae.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chachae
 * @since 2020/1/8 17:13
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Reference(version = "1.0")
  private UserService userService;

  @GetMapping("/list")
  public ResponseEntity<List<User>> listAll() {
    List<User> users = this.userService.listAll();
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getById(@PathVariable Long id) {
    User user = this.userService.getUser(id);
    return ResponseEntity.ok(user);
  }
}
