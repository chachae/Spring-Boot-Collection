package com.chachae.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chachae.entity.Role;
import com.chachae.entity.dto.RoleDTO;

import java.util.Set;

/**
 * @author chachae
 * @date 2019/12/19 13:40
 */
public interface RoleService extends IService<Role> {

  /**
   * 分页模糊查询
   *
   * @param page 分页信息
   * @param dto 模糊搜索条件
   * @return IPage对象
   */
  IPage<Role> pageVO(Page<Role> page, RoleDTO dto);

  /**
   * 新增角色
   *
   * @param role 角色信息
   * @param ids 权限id 集合
   * @return boolean
   */
  boolean save(Role role, Long[] ids);

  /**
   * 更新角色信息
   *
   * @param role 角色信息
   * @param ids 权限id 集合
   * @return boolean
   */
  boolean updateById(Role role, Long[] ids);

  /**
   * 获取用户角色ID
   *
   * @param userId 用户id
   * @return 用户角色id
   */
  Set<String> getRoleByUserId(Long userId);
}
