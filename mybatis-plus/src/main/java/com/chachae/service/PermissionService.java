package com.chachae.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chachae.entity.Permission;
import com.chachae.entity.dto.PermissionDTO;

import java.util.Set;

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
  IPage<Permission> pageVO(Page<Permission> page, PermissionDTO dto);

  /**
   * 通过用户id 获取用户的权限表达式
   *
   * @param userId 用户id
   * @return 用户权限表达式Set 集合
   */
  Set<String> getExpressionByUserId(Long userId);

  /**
   * 获取全部权限表达式
   *
   * @return 权限表达式Set 集合
   */
  Set<String> getAllExpression();
}
