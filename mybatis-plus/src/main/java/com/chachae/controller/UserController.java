package com.chachae.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chachae.bean.Page;
import com.chachae.bean.Result;
import com.chachae.entity.bo.User;
import com.chachae.entity.dto.UserDTO;
import com.chachae.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
