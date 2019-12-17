package com.demo.api.service.impl;

import com.demo.api.dao.UserDao;
import com.demo.api.entity.User;
import com.demo.api.service.UserService;

import java.util.List;

/**
 * @author chachae
 * @date 2019/12/10 13:15
 */
public class UserServiceImpl implements UserService {

  @Override
  public void save(User user) {
    UserDao dao = new UserDao();
    dao.save(user);
  }

  @Override
  public void remove(Long id) {
    UserDao dao = new UserDao();
    dao.remove(id);
  }

  @Override
  public void update(User user) {
    UserDao dao = new UserDao();
    dao.update(user);
  }

  @Override
  public List<User> list() {
    UserDao dao = new UserDao();
    return dao.list();
  }
}
