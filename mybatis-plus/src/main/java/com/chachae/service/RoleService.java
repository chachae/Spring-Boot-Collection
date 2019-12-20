package com.chachae.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chachae.entity.bo.Role;
import com.chachae.entity.dto.RoleDTO;

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
  IPage<Role> selectPage(Page<Role> page, RoleDTO dto);

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
}
