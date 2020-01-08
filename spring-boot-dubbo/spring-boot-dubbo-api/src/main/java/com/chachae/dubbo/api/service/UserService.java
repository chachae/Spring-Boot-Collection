package com.chachae.dubbo.api.service;

import com.chachae.dubbo.api.entity.User;

import java.util.List;

/**
 * @author chachae
 * @since 2020/1/8 16:34
 */
public interface UserService {

  User getUser(Long id);

  List<User> listAll();
}
