package com.chachae.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chachae.bean.Page;
import com.chachae.bean.Result;
import com.chachae.entity.bo.Permission;
import com.chachae.entity.dto.PermissionDTO;
import com.chachae.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author chachae
 * @date 2019/12/19 21:15
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

  @Resource private PermissionService permissionService;

  @GetMapping("/all")
  public Result<List<Permission>> all() {
    List<Permission> list = this.permissionService.list();
    return Result.ok(list);
  }

  @GetMapping("/list")
  public Result<Permission> list(Page<Permission> page, PermissionDTO dto) {
    IPage<Permission> result = this.permissionService.selectPage(page, dto);
    return Result.ok(result);
  }

  @PostMapping("/save")
  public Result<Boolean> save(@Valid Permission permission) {
    boolean res = this.permissionService.save(permission);
    return Result.ok(res);
  }

  @PutMapping("/update")
  public Result<Boolean> update(@Valid Permission permission) {
    boolean res = this.permissionService.updateById(permission);
    return Result.ok(res);
  }

  @DeleteMapping("/delete/{id}")
  public Result<Boolean> delete(@PathVariable Long id) {
    boolean res = this.permissionService.removeById(id);
    return Result.ok(res);
  }
}
