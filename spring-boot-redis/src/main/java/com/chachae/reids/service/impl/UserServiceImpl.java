package com.chachae.reids.service.impl;

import com.chachae.reids.entity.User;
import com.chachae.reids.service.UserService;
import com.google.common.collect.Maps;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author chachae
 * @since 2020/1/8 10:06
 */
@Service
public class UserServiceImpl implements UserService {

  private static Map<Long, User> db = Maps.newConcurrentMap();

  // 静态块初始化Map 数据
  static {
    db.put(1L, new User(1L, "Jack"));
    db.put(2L, new User(2L, "Rose"));
    db.put(3L, new User(3L, "Linda"));
  }

  @CachePut(value = "user", key = "#user.id")
  @Override
  public User saveOrUpdate(User user) {
    db.put(user.getId(), user);
    return user;
  }

  @CacheEvict(value = "user", key = "#id")
  @Override
  public Long delete(Long id) {
    db.remove(id);
    return id;
  }

  @Cacheable(value = "user", key = "#id")
  @Override
  public User getById(Long id) {
    // 用于测试用户信息缓存
    System.out.println("execute......");
    return db.get(id);
  }
}
