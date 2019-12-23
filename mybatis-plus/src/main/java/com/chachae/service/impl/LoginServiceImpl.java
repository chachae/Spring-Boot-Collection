package com.chachae.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.dao.UserDAO;
import com.chachae.entity.bo.User;
import com.chachae.entity.dto.LoginDTO;
import com.chachae.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chachae
 * @since 2019/12/21 12:02
 */
@Service
public class LoginServiceImpl extends ServiceImpl<UserDAO, User> implements LoginService {

  @Resource private UserDAO userDAO;

  @Override
  public User getUserByLoginDTO(LoginDTO dto) {
    QueryWrapper<User> qw = new QueryWrapper<>();
    qw.lambda().eq(User::getUserName, dto.getUserName()).eq(User::getUserName, dto.getUserName());
    User user = this.userDAO.selectOne(qw);
    user.setPassword(null);
    return ObjectUtil.isNotEmpty(user) ? user : User.builder().build();
  }
}
