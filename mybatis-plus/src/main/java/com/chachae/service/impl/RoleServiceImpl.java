package com.chachae.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.dao.RoleDAO;
import com.chachae.dao.UserDAO;
import com.chachae.entity.bo.Role;
import com.chachae.entity.dto.RoleDTO;
import com.chachae.exceptions.ApiException;
import com.chachae.service.RoleService;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author chachae
 * @date 2019/12/19 13:41
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDAO, Role> implements RoleService {

  @Resource private RoleDAO roleDAO;
  @Resource private UserDAO userDAO;

  @Override
  public IPage<Role> pageVO(Page<Role> page, RoleDTO dto) {
    QueryWrapper<Role> qw = new QueryWrapper<>();
    if (StrUtil.isNotEmpty(dto.getKeyword())) {
      qw.lambda().like(Role::getName, dto.getKeyword());
    }
    return this.roleDAO.selectPage(page, qw);
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean save(Role entity, Long[] ids) {
    boolean res = this.save(entity);
    if (res && ids != null) {
      Long roleId = entity.getId();
      Arrays.stream(ids).forEach(id -> this.roleDAO.saveRelation(roleId, id));
    }
    return res;
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean removeById(Serializable id) {
    boolean res = super.removeById(id);
    if (res) {
      this.roleDAO.removeRelation((Long) id);
      this.userDAO.removeRelationByRoleId((Long) id);
    }
    return res;
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean updateById(Role entity, Long[] ids) {
    boolean res = this.updateById(entity);
    if (res && ids != null) {
      Long roleId = entity.getId();
      this.roleDAO.removeRelation(roleId);
      Arrays.stream(ids).forEach(id -> this.roleDAO.saveRelation(roleId, id));
    }
    return res;
  }

  @Override
  public Set<String> getRoleByUserId(Long userId) {
    List<Role> roles = this.roleDAO.selectRoleByUserId(userId);
    Set<String> set = Sets.newHashSet();
    if (ObjectUtil.isNotEmpty(roles)) {
      roles.forEach(role -> set.add(String.valueOf(role.getId())));
    }
    return set;
  }
}
