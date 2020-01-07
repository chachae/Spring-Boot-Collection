package com.chachae.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chachae.bean.Page;
import com.chachae.bean.Result;
import com.chachae.entity.User;
import com.chachae.entity.dto.UserDTO;
import com.chachae.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author chachae
 * @date 2019/12/17 10:18
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Resource private UserService userService;

  /**
   * 模糊查询
   *
   * @param page 分页参数
   * @param dto 模糊条件
   * @return 分页结果
   */
  @GetMapping("/list")
  public Result<User> list(Page<User> page, UserDTO dto) {
    IPage<User> result = this.userService.pageVO(page, dto);
    return Result.ok(result);
  }

  @PostMapping("/save")
  public Result<Boolean> save(@Valid User user, Long[] ids) {
    boolean res = this.userService.save(user, ids);
    return Result.ok(res);
  }

  @PutMapping("/update")
  public Result<Boolean> update(@Valid User user, Long[] ids) {
    boolean res = this.userService.updateById(user, ids);
    return Result.ok(res);
  }

  @DeleteMapping("/delete/{id}")
  public Result<Boolean> delete(@PathVariable Long id) {
    boolean res = this.userService.removeById(id);
    return Result.ok(res);
  }
}
