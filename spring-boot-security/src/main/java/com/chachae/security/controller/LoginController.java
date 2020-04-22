package com.chachae.security.controller;

import com.chachae.security.base.BaseEmployeeInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/4/21 17:07
 */

@RestController
public class LoginController extends BaseEmployeeInfo {

  @RequestMapping("/success")
  public String success() {
    return getUsername() + "：登陆成功，权限：" + getPermissions();
  }

  @PreAuthorize("hasAuthority('employee:list')")
  @GetMapping("/r/{id}")
  public String r(@PathVariable String id) {
    return id;
  }

}
