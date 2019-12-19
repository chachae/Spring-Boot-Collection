package com.chachae.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chachae.entity.bo.Permission;
import com.chachae.entity.bo.User;
import com.chachae.entity.dto.PermissionDTO;

/**
 * @author chachae
 * @date 2019/12/19 21:13
 */
public interface PermissionService extends IService<Permission> {

  /**
   * 分页模糊查询
   *
   * @param page 分页信息
   * @param dto 模糊搜索条件
   * @return IPage对象
   */
  IPage<Permission> selectPage(Page<Permission> page, PermissionDTO dto);
}
