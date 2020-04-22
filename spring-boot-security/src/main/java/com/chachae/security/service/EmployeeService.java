package com.chachae.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chachae.security.entity.Employee;
import com.chachae.security.entity.Role;
import java.util.List;

/**
 * @author chachae
 * @since 2020/4/21 21:36
 */
public interface EmployeeService extends IService<Employee> {

  Employee findByUsername(String username);

  List<String> findByEmployeeId(Long employeeId);

}
