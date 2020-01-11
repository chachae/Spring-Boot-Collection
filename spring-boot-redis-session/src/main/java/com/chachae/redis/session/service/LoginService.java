package com.chachae.redis.session.service;

import com.chachae.redis.session.entity.User;

/**
 * @author chachae
 * @since 2020/1/11 14:47
 */
public interface LoginService {

  Boolean login(User user);
}
