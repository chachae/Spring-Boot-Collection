package com.chachae.dubbo.provider.service;

import com.chachae.dubbo.api.entity.User;
import com.chachae.dubbo.api.service.UserService;
import com.chachae.dubbo.provider.db.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chachae
 * @since 2020/1/8 16:43
 */
@Component
@Service(version = "1.0")
@Slf4j
public class UserServiceImpl implements UserService {

  @Resource private UserDAO userDAO;

  @Override
  public User getUser(Long id) {
    return this.userDAO.findById(id);
  }

  @Override
  public List<User> listAll() {
    return this.userDAO.findAll();
  }
}
