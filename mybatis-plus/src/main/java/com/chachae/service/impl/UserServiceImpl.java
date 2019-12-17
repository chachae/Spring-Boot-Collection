package com.chachae.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.dao.UserDAO;
import com.chachae.entity.bo.User;
import com.chachae.entity.dto.UserDTO;
import com.chachae.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chachae
 * @date 2019/12/16 14:58
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDAO, User> implements UserService {
  @Resource private UserDAO userDAO;

  @Override
  public IPage<User> selectPage(Page<User> page, UserDTO dto) {
    // 模糊条件构造
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    if (StrUtil.isNotEmpty(dto.getKeyword())) {
      wrapper.like("user_name", dto.getKeyword());
    }
    if (dto.getRole() != null) {
      wrapper.eq("role", dto.getRole());
    }
    return this.userDAO.selectPage(page, wrapper);
  }
}
