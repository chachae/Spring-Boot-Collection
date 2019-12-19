package com.chachae.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chachae.entity.bo.User;
import com.chachae.entity.dto.UserDTO;

/**
 * @author chachae
 * @date 2019/12/16 14:58
 */
public interface UserService extends IService<User> {

  /**
   * 分页模糊查询
   *
   * @param page 分页信息
   * @param dto 模糊搜索条件
   * @return IPage对象
   */
  IPage<User> selectPage(Page<User> page, UserDTO dto);

  /**
   * 新增用户
   *
   * @param entity 用户信息
   * @param ids 角色id
   * @return boolean
   */
  boolean save(User entity, Long[] ids);

  /**
   * 关系用户信息
   *
   * @param entity 用户信息
   * @param ids 角色id
   * @return boolean
   */
  boolean updateById(User entity, Long[] ids);
}
