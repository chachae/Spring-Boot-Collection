package com.chachae.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chachae.bean.Page;
import com.chachae.bean.Result;
import com.chachae.entity.Department;
import com.chachae.entity.dto.DepartmentDTO;
import com.chachae.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chachae
 * @date 2019/12/20 14:45
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

  @Resource private DepartmentService departmentService;

  @GetMapping("/all")
  public Result<List<Department>> all() {
    List<Department> list = this.departmentService.list();
    return Result.ok(list);
  }

  @GetMapping("/list")
  public Result<Department> list(Page<Department> page, DepartmentDTO dto) {
    IPage<Department> result = this.departmentService.pageVO(page, dto);
    return Result.ok(result);
  }

  @DeleteMapping("/delete/{id}")
  public Result<Boolean> delete(@PathVariable Long id) {
    boolean res = this.departmentService.removeById(id);
    return Result.ok(res);
  }
}
