package cn.chachae.me.part.itf;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author chachae
 * @date 2019/11/7 19:57
 */
public class StudentServiceImpl extends StudentService {

  private static List<Student> list = Lists.newArrayList();

  // 静态域列表增加数据
  static {
    list.add(new Student(0, 1L, "Rose", "123", 1));
    list.add(new Student(1, 2L, "Mike", "456", 2));
    list.add(new Student(2, 3L, "Peter", "789", 3));
  }

  @Override
  List<Student> get() {
    return list;
  }

  @Override
  void delete() {
    list.remove(0);
  }

  @Override
  void insert(Student student) {}

  @Override
  void modify(Student student) {
    // 获取学生索引
    int index = student.getIndex();
    // 被修改的学生
    Student modifiedStudent = get().get(index);
    // 修改
    modifiedStudent.setId(student.getId());
    modifiedStudent.setUsername(student.getUsername());
    modifiedStudent.setPassword(student.getPassword());
    modifiedStudent.setRole(student.getRole());
  }

  @Override
  Student getById() {
    return get().get(0);
  }

  @Override
  List<Map<Object, Object>> getIndexAndId() {
    List<Student> list = get();
    List<Map<Object, Object>> result = Lists.newArrayList();
    list.forEach(
        student -> {
          Map<Object, Object> map = Maps.newHashMap();
          map.put("index", student.getIndex());
          map.put("id", student.getId());
          result.add(map);
        });
    return result;
  }
}
