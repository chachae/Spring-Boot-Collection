package com.chachae.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chachae.bean.Page;
import com.chachae.bean.Result;
import com.chachae.entity.bo.User;
import com.chachae.entity.dto.UserDTO;
import com.chachae.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author chachae
 * @date 2019/12/17 10:18
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Resource private UserService userService;

  @GetMapping("/list")
  public Result<User> list(Page<User> page, UserDTO dto) {
    IPage<User> result = this.userService.selectPage(page, dto);
    return Result.ok(result);
  }

  @PostMapping("/save")
  public Result<User> save(User user) {
    this.userService.save(user);
    return Result.ok(user);
  }

  @PutMapping("/update")
  public Result<User> update(User user) {
    this.userService.updateById(user);
    return Result.ok(user);
  }

  @DeleteMapping("/delete/{id}")
  public Result<Boolean> delete(@PathVariable Long id) {
    boolean res = this.userService.removeById(id);
    return Result.ok(res);
  }
}
