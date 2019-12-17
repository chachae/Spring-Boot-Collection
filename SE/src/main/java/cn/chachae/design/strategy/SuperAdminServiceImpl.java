package cn.chachae.design.strategy;

/**
 * @author chachae
 * @date 2019/12/10 9:45
 */
public class SuperAdminServiceImpl implements UserService {

  private String roleName;

  public SuperAdminServiceImpl(String roleName) {
    this.roleName = roleName;
  }

  @Override
  public String op() {
    return roleName + ":super admin operate......";
  }
}
