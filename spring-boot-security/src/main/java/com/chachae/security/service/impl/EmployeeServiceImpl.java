package com.chachae.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.security.dao.EmployeeDAO;
import com.chachae.security.entity.Employee;
import com.chachae.security.service.EmployeeService;
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

  public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
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
    return ObjectUtils.isEmpty(employee) ? null
        : User.withUsername(employee.getUsername()).password(employee.getPassword())
            .authorities("p1").build();
  }

  @Override
  public Employee findByUsername(String username) {
    QueryWrapper<Employee> qw = new QueryWrapper<>();
    qw.lambda().eq(Employee::getUsername, username);
    return employeeDAO.selectOne(qw);
  }
}
