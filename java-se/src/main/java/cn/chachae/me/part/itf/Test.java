package cn.chachae.me.part.itf;

import cn.hutool.core.lang.Console;

import java.util.List;
import java.util.Map;

/**
 * @author chachae
 * @date 2019/11/7 20:24
 */
public class Test {

  /** 多态 */
  private StudentService studentService = new StudentServiceImpl();

  private AdminService adminService = new AdminServiceImpl();

  @org.junit.Test
  public void test() {
    List<Student> list = this.studentService.get();
    list.forEach(Console::log);
  }

  @org.junit.Test
  public void delete() {
    // 删除索引0的数据
    studentService.delete();
    List<Student> list = this.studentService.get();
    list.forEach(Console::log);
  }

  @org.junit.Test
  public void update() {
    // 修改
    Student student = new Student(0, 1L, "RICK", "00000", 0);
    this.studentService.modify(student);
    // 获取索引0数据
    Student print = this.studentService.get().get(0);
    Console.log(print);
  }

  @org.junit.Test
  public void insert() {
    Admin admin = new Admin(4, 10L);
    adminService.insert(admin);
    List<Admin> listAdmin = adminService.get();
    listAdmin.forEach(Console::log);
  }

  @org.junit.Test
  public void getById() {
    Admin admin = adminService.getById();
    Console.log(admin);
  }

  @org.junit.Test
  public void indexAndId() {
    List<Map<Object, Object>> list = studentService.getIndexAndId();
    list.forEach(Console::log);
  }
}
