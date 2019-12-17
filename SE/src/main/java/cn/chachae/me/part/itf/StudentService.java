package cn.chachae.me.part.itf;

import java.util.List;

/**
 * @author chachae
 * @date 2019/11/7 19:57
 */
public abstract class StudentService extends UserFactory<Student> {

  /**
   * 获取
   *
   * @return 列表信息
   */
  @Override
  abstract List<Student> get();

  /**
   * 删除
   *
   */
  @Override
  abstract void delete();

  /**
   * 修改
   *
   * @param student 修改的信息
   */
  @Override
  abstract void modify(Student student);
}
