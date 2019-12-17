package com.demo.api.dao;

import cn.hutool.core.lang.Console;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.demo.api.entity.User;
import com.demo.api.utils.DbUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chachae
 * @date 2019/12/10 13:06
 */
public class UserDao {

  /**
   * insert
   *
   * @param user user info
   */
  public void save(User user) {
    DbUtil.save(user);
  }

  /**
   * remove by id
   *
   * @param id id
   */
  public void remove(Long id) {
    DbUtil.remove(id);
  }

  /**
   * update info
   *
   * @param user user info
   */
  public void update(User user) {
    DbUtil.update(user);
  }

  /**
   * get all user info
   *
   * @return list
   */
  public List<User> list() {



    List<Entity> entities = null;


    List<User> users = new ArrayList<>();




    try {
      entities = Db.use().findAll("user");
    } catch (SQLException e) {
      Console.error("error info: {}", e);
    }
    // 断言
    assert entities != null;
    for (Entity e : entities) {
      User user = new User();
      user.setId(e.getLong("id"));
      user.setUsername(e.getStr("username"));
      user.setPassword(e.getStr("password"));
      user.setRole(e.getInt("role"));
      users.add(user);
    }
    return users;
  }
}
