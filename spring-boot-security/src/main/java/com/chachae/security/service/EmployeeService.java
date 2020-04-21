package com.chachae.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chachae.security.entity.Employee;

/**
 * @author chachae
 * @since 2020/4/21 21:36
 */
public interface EmployeeService extends IService<Employee> {

  Employee findByUsername(String username);

}
