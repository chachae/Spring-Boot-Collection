package com.demo.api.service;

import com.demo.api.entity.User;

import java.util.List;

/**
 * @author chachae
 * @date 2019/12/10 13:14
 */
public interface UserService {

  void save(User user);

  void remove(Long id);

  void update(User user);

  List<User> list();
}
