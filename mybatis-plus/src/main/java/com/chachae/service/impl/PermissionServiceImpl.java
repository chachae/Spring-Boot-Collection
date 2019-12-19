package com.chachae.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.dao.PermissionDAO;
import com.chachae.dao.RoleDAO;
import com.chachae.entity.bo.Permission;
import com.chachae.entity.dto.PermissionDTO;
import com.chachae.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

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
  public IPage<Permission> selectPage(Page<Permission> page, PermissionDTO dto) {
    QueryWrapper<Permission> qw = new QueryWrapper<>();
    if (StrUtil.isNotEmpty(dto.getKeyword())) {
      qw.like("name", dto.getKeyword());
    }
    return this.permissionDAO.selectPage(page, qw);
  }

  @Override
  public boolean removeById(Serializable id) {
    boolean res = super.removeById(id);
    if (res) {
      this.roleDAO.removeRelationByPermissionId((Long) id);
    }
    return res;
  }
}
