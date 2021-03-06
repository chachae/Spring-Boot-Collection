package com.chachae.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.dao.UserDAO;
import com.chachae.dao.UserInfoDAO;
import com.chachae.entity.User;
import com.chachae.entity.UserInfo;
import com.chachae.entity.dto.UserDTO;
import com.chachae.exceptions.ApiException;
import com.chachae.service.UserService;
import com.chachae.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Arrays;

/**
 * @author chachae
 * @date 2019/12/16 14:58
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDAO, User> implements UserService {

  @Resource private UserDAO userDAO;
  @Resource private UserInfoDAO userInfoDAO;

  @Override
  public IPage<User> pageVO(Page<User> page, UserDTO dto) {
    // 模糊条件构造
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    if (StrUtil.isNotEmpty(dto.getKeyword())) {
      wrapper.lambda().like(User::getUserName, dto.getKeyword());
    }
    Page<User> res = this.userDAO.selectPage(page, wrapper);
    if (ObjectUtil.isNotEmpty(res.getRecords())) {
      // 密码设置空
      res.getRecords().forEach(item -> item.setPassword(null));
    }
    return res;
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean save(User entity, Long[] ids) {
    // 用户账号默认不锁定
    entity.setStatus(Boolean.TRUE);
    boolean res = this.save(entity);
    // 主键
    Long userId = entity.getId();
    if (res && ids != null) {
      // 用户角色中间表中增加数据
      Arrays.stream(ids).forEach(id -> this.userDAO.saveRelation(userId, id));
    }
    // 用户信息表中插入数据
    UserInfo info = new UserInfo().setId(userId).setCreateTime(DateUtil.nowDate());
    this.userInfoDAO.insert(info);
    return res;
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean updateById(User entity, Long[] ids) {
    boolean res = this.updateById(entity);
    if (res && ids != null) {
      Long userId = entity.getId();
      // 删除用户角色中间表中原有的数据再新增
      this.userDAO.removeRelation(userId);
      Arrays.stream(ids).forEach(id -> this.userDAO.saveRelation(userId, id));
    }
    return res;
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean removeById(Serializable id) {
    boolean res = super.removeById(id);
    if (res) {
      this.userDAO.removeRelation((Long) id);
      QueryWrapper<UserInfo> qw = new QueryWrapper<>();
      qw.lambda().eq(UserInfo::getId, id);
      this.userInfoDAO.delete(qw);
    }
    return res;
  }
}
