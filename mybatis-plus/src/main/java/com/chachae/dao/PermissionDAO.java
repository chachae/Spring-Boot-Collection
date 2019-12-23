package com.chachae.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chachae.entity.bo.Permission;

import java.util.List;

/**
 * @author chachae
 * @date 2019/12/19 21:12
 */
public interface PermissionDAO extends BaseMapper<Permission> {

  /**
   * 通过用户id 获取权限信息
   *
   * @param userId 用户id
   * @return 权限信息
   */
  List<Permission> selectPermissionByUserId(Long userId);
}
