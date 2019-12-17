package cn.chachae.me.name;

import java.util.List;

/**
 * 命名规范
 *
 * @author chachae
 * @date 2019/12/10 10:48
 */
public interface EmployeeService {

  /**
   * 模糊搜索
   *
   * @param employeeDTO 模糊搜索条件
   * @return 分页结果集封装下的员工信息
   */
  PageResult query(EmployeeDTO employeeDTO);

  /**
   * 获取所有员工
   *
   * @return List
   */
  List<Employee> listAll();

  /**
   * 通过id 获取单个员工对象
   *
   * @param id 员工id
   * @return 对应id 的员工信息
   */
  Employee getEmployeeById(Long id);

  /**
   * 统计员工数量
   *
   * @return 员工数量
   */
  Integer countEmployee();

  /**
   * 新增员工
   *
   * @param employee 员工新增信息
   * @return 员工自增id
   */
  int save(Employee employee);

  /**
   * 通过id 移除员工
   *
   * @param id 员工id
   */
  void remove(Long id);

  /**
   * 更新员工信息
   *
   * @param employee 员工信息
   * @return 员工id
   */
  int update(Employee employee);
}
