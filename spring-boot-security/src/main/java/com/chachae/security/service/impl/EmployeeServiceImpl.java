package com.chachae.security.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.security.dao.EmployeeDAO;
import com.chachae.security.dao.PermissionDAO;
import com.chachae.security.entity.Employee;
import com.chachae.security.entity.Permission;
import com.chachae.security.service.EmployeeService;
import java.util.List;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author chachae
 * @since 2020/4/21 21:36
 */

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDAO, Employee> implements
    EmployeeService, UserDetailsService {

  private final EmployeeDAO employeeDAO;
  private final PermissionDAO permissionDAO;

  public EmployeeServiceImpl(EmployeeDAO employeeDAO, PermissionDAO permissionDAO) {
    this.employeeDAO = employeeDAO;
    this.permissionDAO = permissionDAO;
  }

  /**
   * Spring Security 认证
   *
   * @param username 用户名
   * @return /
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Employee employee = this.findByUsername(username);
    if (ObjectUtils.isEmpty(employee)) {
      return null;
    } else {
      // 角色
      List<String> roleIds = findByEmployeeId(employee.getId());
      // 权限
      String[] expressions = new String[0];
      if (CollUtil.isNotEmpty(roleIds)) {
        List<String> permissionIds = permissionDAO.selectPermissionIdByRoleId(roleIds);
        List<Permission> permissions = permissionDAO.selectBatchIds(permissionIds);
        expressions = permissions.stream().map(Permission::getExpression)
            .toArray(String[]::new);
      }
      // 构建用户信息
      return User
          .withUsername(employee.getUsername())
          .password(employee.getPassword())
          .authorities(expressions)
          .build();
    }
  }

  @Override
  public Employee findByUsername(String username) {
    QueryWrapper<Employee> qw = new QueryWrapper<>();
    qw.lambda().eq(Employee::getUsername, username);
    return employeeDAO.selectOne(qw);
  }

  @Override
  public List<String> findByEmployeeId(Long employeeId) {
    return employeeDAO.selectRoleIdByEmployeeId(employeeId);
  }
}
