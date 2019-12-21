package com.chachae.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chachae.entity.bo.User;

/**
 * @author chachae
 * @date 2019/12/16 14:37
 */
public interface UserDAO extends BaseMapper<User> {

  /**
   * 新增用户角色中间表数据
   *
   * @param userId 用户id
   * @param roleId 角色id 集合
   * @return boolean
   */
  boolean saveRelation(Long userId, Long roleId);

  /**
   * 删除用户角色中间表数据
   *
   * @param userId 用户id
   * @return boolean
   */
  boolean removeRelation(Long userId);

  /**
   * 删除用户角色中间表数据
   *
   * @param roleId 角色id
   * @return boolean
   */
  boolean removeRelationByRoleId(Long roleId);
}
