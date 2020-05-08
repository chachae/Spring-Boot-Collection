package com.chachae.shardingjdbc.controller;

import com.chachae.shardingjdbc.entity.User;
import com.chachae.shardingjdbc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/5/8 18:04
 */

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/insert")
  public User insert(User user) {
    userService.save(user);
    return userService.getById(user.getUserId());
  }

}
