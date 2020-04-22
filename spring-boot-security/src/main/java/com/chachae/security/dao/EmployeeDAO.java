package com.chachae.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chachae.security.entity.Employee;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author chachae
 * @since 2020/4/21 21:35
 */
public interface EmployeeDAO extends BaseMapper<Employee> {

  @Select("select role_id from employee_role where employee_id = #{employeeId}")
  List<String> selectRoleIdByEmployeeId(@Param("employeeId") Long employeeId);

}
