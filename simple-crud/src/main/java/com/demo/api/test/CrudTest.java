package com.demo.api.test;

import cn.hutool.core.lang.Console;
import com.demo.api.entity.User;
import com.demo.api.service.UserService;
import com.demo.api.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author chachae
 * @date 2019/12/10 13:02
 */
public class CrudTest {

  private UserService userService = new UserServiceImpl();

  @Test
  public void save() {
    User user = new User("sw", "700900", 4);
    this.userService.save(user);
  }

  @Test
  public void del() {
    userService.remove(1L);
  }

  @Test
  public void update() {
    User user = new User(3L, "kke", "00000", 1);
    userService.update(user);
  }

  @Test
  public void listAll() {
    List<User> users = userService.list();
    users.forEach(Console::log);
  }
}
