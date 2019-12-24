package cn.chachae.design.factory;

/**
 * @author chachae
 * @date 2019/12/10 9:47
 */
public class AdminServiceImpl implements UserService {

  private String roleName;

  public AdminServiceImpl(String roleName) {
    this.roleName = roleName;
  }

  @Override
  public String op() {
    return roleName + ":admin operate......";
  }
}
