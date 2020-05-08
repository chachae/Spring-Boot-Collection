package com.chachae.shardingjdbc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.shardingjdbc.config.IdGenerator;
import com.chachae.shardingjdbc.entity.User;
import com.chachae.shardingjdbc.mapper.UserMapper;
import com.chachae.shardingjdbc.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * (TUser0)表服务实现类
 *
 * @author chachae
 * @since 2020-05-08 18:00:52
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

  @Override
  public boolean save(User entity) {
    long userId = IdGenerator.getId();
    log.info("当前插入的用户ID：{}", userId);
    entity.setUserId(userId);
    baseMapper.insert(entity);
    return true;
  }
}