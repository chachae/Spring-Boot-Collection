package com.chachae.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chachae.entity.bo.Role;
import org.apache.ibatis.annotations.Param;

/**
 * @author chachae
 * @date 2019/12/19 13:39
 */
public interface RoleDAO extends BaseMapper<Role> {

  /**
   * 新增角色权限中间表数据
   *
   * @param roleId 角色id
   * @param ids 权限id 集合
   * @return boolean
   */
  boolean saveRelation(@Param("roleId") Long roleId, @Param("permissionId") Long ids);

  /**
   * 删除角色权限中间表数据
   *
   * @param roleId 角色id
   * @return boolean
   */
  boolean removeRelation(@Param("roleId") Long roleId);

  /**
   * 通过权限id 删除角色权限中间表数据
   *
   * @param permissionId 权限id
   * @return boolean
   */
  boolean removeRelationByPermissionId(@Param("permissionId") Long permissionId);
}
