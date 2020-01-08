package com.chachae.reids.service;

import com.chachae.reids.entity.User;

/**
 * @author chachae
 * @since 2020/1/8 9:59
 */
public interface UserService {

  User saveOrUpdate(User user);

  Long delete(Long id);

  User getById(Long id);
}
