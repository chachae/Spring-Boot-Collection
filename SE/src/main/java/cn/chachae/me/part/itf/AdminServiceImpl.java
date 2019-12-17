package cn.chachae.me.part.itf;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

/**
 * @author chachae
 * @date 2019/11/7 19:57
 */
public class AdminServiceImpl extends AdminService {

  private static List<Admin> list = Lists.newArrayList();

  // 静态域列表增加数据
  static {
    list.add(new Admin(0, 1L));
    list.add(new Admin(1, 2L));
    list.add(new Admin(2, 3L));
  }

  @Override
  List<Admin> get() {
    return list;
  }

  @Override
  void delete() {
    list.remove(0);
  }

  @Override
  void insert(Admin admin) {
    list.add(new Admin(admin.getIndex(), admin.getId()));
  }

  @Override
  void modify(Admin admin) {
    // 获取学生索引
    int index = admin.getIndex();
    // 被修改的学生
    Admin modifiedAdmin = get().get(index);
    // 修改
    modifiedAdmin.setId(admin.getId());
  }

  @Override
  Admin getById() {
    return get().get(0);
  }

  @Override
  List<Map<Object, Object>> getIndexAndId() {
    return null;
  }
}
