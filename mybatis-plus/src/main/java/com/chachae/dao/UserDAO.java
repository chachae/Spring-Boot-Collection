package com.chachae.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chachae.entity.bo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author chachae
 * @date 2019/12/16 14:37
 */
public interface UserDAO extends BaseMapper<User> {

  /**
   * 新增用户角色中间表数据
   *
   * @param userId 用户id
   * @param ids 角色id 集合
   * @return boolean
   */
  boolean saveRelation(@Param("userId") Long userId, @Param("roleId") Long ids);

  /**
   * 删除用户角色中间表数据
   *
   * @param userId 用户id
   * @return boolean
   */
  boolean removeRelation(@Param("userId") Long userId);
}
