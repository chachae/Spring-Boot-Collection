package com.chachae.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chachae.entity.bo.User;
import com.chachae.entity.dto.LoginDTO;

/**
 * @author chachae
 * @since 2019/12/21 12:02
 */
public interface LoginService extends IService<User> {

  /**
   * 获取用户
   *
   * @param dto 认证信息
   * @return 用户登录信息
   */
  User getUserByLoginDTO(LoginDTO dto);
}
