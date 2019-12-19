package com.chachae.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.dao.UserDAO;
import com.chachae.entity.bo.User;
import com.chachae.entity.dto.UserDTO;
import com.chachae.exceptions.ApiException;
import com.chachae.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;

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
    Page<User> res = this.userDAO.selectPage(page, wrapper);
    if (res.getRecords().size() > 0) {
      // 密码设置空
      res.getRecords().forEach(item -> item.setPassword(null));
    }
    return res;
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean save(User entity, Long[] ids) {
    boolean res = super.save(entity);
    if (res && ids.length > 0) {
      Long userId = entity.getId();
      // 用户角色中间表中增加数据
      for (Long id : ids) {
        this.userDAO.saveRelation(userId, id);
      }
    }
    return res;
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean updateById(User entity, Long[] ids) {
    boolean res = super.updateById(entity);
    if (res && ids.length > 0) {
      Long userId = entity.getId();
      // 删除用户角色中间表中原有的数据再新增
      this.userDAO.removeRelation(userId);
      for (Long id : ids) {
        this.userDAO.saveRelation(userId, id);
      }
    }
    return res;
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean removeById(Serializable id) {
    boolean res = super.removeById(id);
    if (res) {
      this.userDAO.removeRelation((Long) id);
    }
    return res;
  }
}
