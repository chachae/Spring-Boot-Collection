package com.chachae.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chachae.bean.Page;
import com.chachae.bean.Result;
import com.chachae.entity.bo.Role;
import com.chachae.entity.dto.RoleDTO;
import com.chachae.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author chachae
 * @date 2019/12/19 13:46
 */
@RestController
@RequestMapping("/role")
public class RoleController {

  @Resource private RoleService roleService;

  @GetMapping("/all")
  public Result<List<Role>> all() {
    List<Role> list = this.roleService.list();
    return Result.ok(list);
  }

  @GetMapping("/list")
  public Result<Role> list(Page<Role> page, RoleDTO dto) {
    IPage<Role> result = this.roleService.pageVO(page, dto);
    return Result.ok(result);
  }

  @PostMapping("/save")
  public Result<Boolean> save(@Valid Role role, Long[] ids) {
    boolean res = this.roleService.save(role, ids);
    return Result.ok(res);
  }

  @DeleteMapping("/delete/{id}")
  public Result<Boolean> delete(@PathVariable Long id) {
    boolean res = this.roleService.removeById(id);
    return Result.ok(res);
  }

  @PutMapping("/update")
  public Result<Boolean> update(@Valid Role role, Long[] ids) {
    boolean res = this.roleService.updateById(role, ids);
    return Result.ok(res);
  }
}
