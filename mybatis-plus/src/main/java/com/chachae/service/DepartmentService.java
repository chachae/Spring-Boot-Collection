package com.chachae.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chachae.entity.bo.Department;
import com.chachae.entity.dto.DepartmentDTO;

/**
 * @author chachae
 * @since 2019/12/20 14:43
 */
public interface DepartmentService extends IService<Department> {

  /**
   * 分页模糊查询
   *
   * @param page 分页信息
   * @param dto 模糊搜索条件
   * @return IPage对象
   */
  IPage<Department> selectPage(Page<Department> page, DepartmentDTO dto);
}
