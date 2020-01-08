package com.chachae.controller;

import com.chachae.entity.User;
import com.chachae.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chachae
 * @since 2020/1/7 23:15
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Resource private UserService userService;

  @GetMapping("/list")
  public ResponseEntity<List<User>> listAll() {
    List<User> users = this.userService.listAll();
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> listAll(@PathVariable Long id) {
    User user = this.userService.getUserById(id);
    return ResponseEntity.ok(user);
  }

  @PostMapping("/save")
  public ResponseEntity<Long> saveUser(User user) {
    Long id = this.userService.insert(user);
    return ResponseEntity.ok(id);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Long> saveUser(@PathVariable Long id) {
    id = this.userService.remove(id);
    return ResponseEntity.ok(id);
  }

  @PutMapping("/update")
  public ResponseEntity<Long> updateUser(User user) {
    Long id = this.userService.update(user);
    return ResponseEntity.ok(id);
  }
}
