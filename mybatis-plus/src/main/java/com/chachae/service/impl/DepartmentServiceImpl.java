package com.chachae.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.dao.DepartmentDAO;
import com.chachae.dao.UserInfoDAO;
import com.chachae.entity.bo.Department;
import com.chachae.entity.bo.UserInfo;
import com.chachae.entity.dto.DepartmentDTO;
import com.chachae.exceptions.ApiException;
import com.chachae.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author chachae
 * @date 2019/12/20 14:44
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDAO, Department>
    implements DepartmentService {

  @Resource private DepartmentDAO departmentDAO;
  @Resource private UserInfoDAO userInfoDAO;

  @Override
  public IPage<Department> pageVO(Page<Department> page, DepartmentDTO dto) {
    QueryWrapper<Department> qw = new QueryWrapper<>();
    if (StrUtil.isNotEmpty(dto.getKeyword())) {
      qw.lambda().like(Department::getName, dto.getKeyword());
    }
    return this.departmentDAO.selectPage(page, qw);
  }

  @Override
  @Transactional(rollbackFor = ApiException.class)
  public boolean removeById(Serializable id) {
    // 查询是否有存在于该部门的员工
    QueryWrapper<UserInfo> qw = new QueryWrapper<>();
    qw.lambda().eq(UserInfo::getDepartmentId, id);
    Integer count = this.userInfoDAO.selectCount(qw);
    if (!count.equals(0)) {
      throw ApiException.argError("部门中存在员工，不允许删除！");
    }
    return super.removeById(id);
  }
}
