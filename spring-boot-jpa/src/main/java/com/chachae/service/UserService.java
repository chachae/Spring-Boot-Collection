package com.chachae.service;

import com.chachae.entity.User;

import java.util.List;

/**
 * @author chachae
 * @since 2020/1/7 23:09
 */
public interface UserService {

  /**
   * 查询全部
   *
   * @return List<User>
   */
  List<User> listAll();

  /**
   * 通过id 查询成员
   *
   * @param id 成员id
   * @return User
   */
  User getUserById(Long id);

  Long insert(User user);

  Long remove(Long id);

  Long update(User user);
}
