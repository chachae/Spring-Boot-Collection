package com.chachae.dubbo.provider.db;

import cn.hutool.core.util.ObjectUtil;
import com.chachae.dubbo.api.entity.User;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 持久层
 *
 * @author chachae
 * @since 2020/1/8 17:04
 */
@Component
public class UserDAO {

  private static Map<Long, User> db = Maps.newConcurrentMap();

  // 模拟数据库，静态块初始化数据
  static {
    db.put(1L, new User(1L, "Mike"));
    db.put(2L, new User(2L, "Joe"));
    db.put(3L, new User(3L, "Rose"));
    db.put(4L, new User(4L, "Peter"));
    db.put(5L, new User(5L, "John"));
    db.put(6L, new User(6L, "Sue"));
    db.put(7L, new User(7L, "Linda"));
    db.put(8L, new User(8L, "Anko"));
  }

  public List<User> findAll() {
    List<User> list = Lists.newArrayList();
    Set<Map.Entry<Long, User>> entries = db.entrySet();
    for (Map.Entry<Long, User> entry : entries) {
      list.add(entry.getValue());
    }
    return list;
  }

  public User findById(Long id) {
    User entity = db.get(id);
    if (ObjectUtil.isNotEmpty(entity)) {
      return entity;
    }
    throw new RuntimeException("用户不存在");
  }
}
