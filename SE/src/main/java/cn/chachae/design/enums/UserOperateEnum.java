package cn.chachae.design.enums;

/**
 * 枚举操作
 *
 * @author chachae
 * @date 2019/12/10 9:10
 */
public enum UserOperateEnum implements UserService {

  // super admin operate
  ROLE_SUPER_ADMIN {
    @Override
    public String op() {
      // 实现逻辑
      return "super admin operate ......";
    }
  },

  // admin operate
  ROLE_ADMIN {
    @Override
    public String op() {
      return "admin operate ......";
    }
  },

  // normal operate
  ROLE_NORMAL {
    @Override
    public String op() {
      return "normal user operate ......";
    }
  },
}
