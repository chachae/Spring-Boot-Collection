package com.chachae.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.dao.PermissionDAO;
import com.chachae.dao.RoleDAO;
import com.chachae.entity.Permission;
import com.chachae.entity.dto.PermissionDTO;
import com.chachae.exceptions.ApiException;
import com.chachae.service.PermissionService;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author chachae
 * @date 2019/12/19 21:13
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDAO, Permission>
    implements PermissionService {

  @Resource private PermissionDAO permissionDAO;
  @Resource private RoleDAO roleDAO;

  @Override
  public IPage<Permission> pageVO(Page<Permission> page, PermissionDTO dto) {
    QueryWrapper<Permission> qw = new QueryWrapper<>();
    if (StrUtil.isNotEmpty(dto.getKeyword())) {
      qw.lambda().like(Permission::getName, dto.getKeyword());
    }
    return this.permissionDAO.selectPage(page, qw);
  }

  @Override
  public Set<String> getExpressionByUserId(Long userId) {
    List<Permission> pms = this.permissionDAO.selectPermissionByUserId(userId);
    return getExpression(pms);
  }

  @Override
  public Set<String> getAllExpression() {
    List<Permission> pms = this.permissionDAO.selectList(null);
    return getExpression(pms);
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean removeById(Serializable id) {
    boolean res = super.removeById(id);
    this.roleDAO.removeRelationByPermissionId((Long) id);
    return res;
  }

  /**
   * 从权限信息中提取权限表达式
   *
   * @param list 权限信息
   * @return 权限表达式Set 集合
   */
  private Set<String> getExpression(List<Permission> list) {
    Set<String> set = Sets.newHashSet();
    if (ObjectUtil.isNotEmpty(list)) {
      list.forEach(pm -> set.add(pm.getExpression()));
    }
    return set;
  }
}
