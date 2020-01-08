package com.chachae.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.chachae.entity.User;
import com.chachae.repository.UserDAO;
import com.chachae.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author chachae
 * @since 2020/1/7 23:10
 */
@Service("userService")
public class UserServiceImpl implements UserService {

  @Resource private UserDAO userDAO;

  @Override
  public List<User> listAll() {
    List<User> list = this.userDAO.findAll();
    if (ObjectUtil.isNotEmpty(list)) {
      list.forEach(entity -> entity.setPassword(null));
      return list;
    }
    throw new RuntimeException("用户不存在");
  }

  @Override
  public User getUserById(Long id) {
    Optional<User> res = this.userDAO.findById(id);
    if (res.isPresent()) {
      User entity = res.get();
      entity.setPassword(null);
      return entity;
    }
    throw new RuntimeException("用户不存在");
  }

  @Override
  public Long insert(User user) {
    User res = this.userDAO.save(user);
    return res.getId();
  }

  @Override
  public Long remove(Long id) {
    this.userDAO.deleteById(id);
    return id;
  }

  @Override
  public Long update(User user) {
    User res = this.userDAO.save(user);
    return res.getId();
  }
}
