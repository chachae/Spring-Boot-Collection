package com.chachae.controller;

import com.chachae.Constants.SysConsts;
import com.chachae.bean.Result;
import com.chachae.entity.User;
import com.chachae.entity.dto.LoginDTO;
import com.chachae.exceptions.ApiException;
import com.chachae.service.CaptchaService;
import com.chachae.service.LoginService;
import com.chachae.service.PermissionService;
import com.chachae.service.RoleService;
import com.chachae.util.HttpContextUtil;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;
import java.util.Set;

/**
 * @author chachae
 * @date 2019/12/19 19:26
 */
@RestController
@RequestMapping("/test")
public class TestController {

  @Resource private LoginService loginService;
  @Resource private RoleService roleService;
  @Resource private PermissionService permissionService;
  @Resource private CaptchaService captchaService;

  @GetMapping("/exception")
  public void exception(String args) {
    try {
      int a = Integer.valueOf(args) / 0;
    } catch (Exception e) {
      throw ApiException.argError("参数异常");
    }
  }

  @PostMapping("/login")
  public Result<User> login(@Valid LoginDTO dto) {
    if (!this.captchaService.verify(dto.getCaptcha())) {
      throw ApiException.argError("验证码错误");
    }
    User user = this.loginService.getUserByLoginDTO(dto);
    return Result.ok(user);
  }

  @GetMapping("pms/{userId}")
  public Result<Set<String>> getPmsExpressionByUserId(@PathVariable Long userId) {
    Set<String> set = this.permissionService.getExpressionByUserId(userId);
    return Result.ok(set);
  }

  @GetMapping("pms/all")
  public Result<Set<String>> getPmsExpressionByUserId() {
    Set<String> set = this.permissionService.getAllExpression();
    return Result.ok(set);
  }

  @GetMapping("roles/{userId}")
  public Result<Set<String>> getRoleByUserId(@PathVariable Long userId) {
    Set<String> set = this.roleService.getRoleByUserId(userId);
    return Result.ok(set);
  }

  @GetMapping("/captcha")
  public Result<Map<String, String>> captcha() {
    String captcha = this.captchaService.getCaptcha();
    Object obj = HttpContextUtil.getSession(SysConsts.CAPTCHA);
    Map<String, String> map = Maps.newHashMap();
    map.put("base64", captcha);
    map.put("text", obj.toString());
    return Result.ok(map);
  }
}
