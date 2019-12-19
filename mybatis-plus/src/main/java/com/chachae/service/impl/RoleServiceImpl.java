package com.chachae.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.dao.RoleDAO;
import com.chachae.entity.bo.Role;
import com.chachae.entity.dto.RoleDTO;
import com.chachae.exceptions.ApiException;
import com.chachae.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author chachae
 * @date 2019/12/19 13:41
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDAO, Role> implements RoleService {

  @Resource private RoleDAO roleDAO;

  @Override
  public IPage<Role> selectPage(Page<Role> page, RoleDTO dto) {
    QueryWrapper<Role> qw = new QueryWrapper<>();
    if (StrUtil.isNotEmpty(dto.getKeyword())) {
      qw.like("name", dto.getKeyword());
    }
    return this.roleDAO.selectPage(page, qw);
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean save(Role entity, Long[] ids) {
    boolean res = super.save(entity);
    if (res && ids.length > 0) {
      Long roleId = entity.getId();
      for (Long id : ids) {
        this.roleDAO.saveRelation(roleId, id);
      }
    }
    return res;
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean removeById(Serializable id) {
    boolean res = super.removeById(id);
    if (res) {
      this.roleDAO.removeRelation((Long) id);
    }
    return res;
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean updateById(Role entity, Long[] ids) {
    boolean res = super.updateById(entity);
    if (res && ids.length > 0) {
      Long roleId = entity.getId();
      this.roleDAO.removeRelation(roleId);
      for (Long id : ids) {
        this.roleDAO.saveRelation(roleId, id);
      }
    }
    return res;
  }
}
