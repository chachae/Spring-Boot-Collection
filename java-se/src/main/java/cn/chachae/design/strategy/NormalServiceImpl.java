package cn.chachae.design.strategy;

/**
 * @author chachae
 * @date 2019/12/10 9:47
 */
public class NormalServiceImpl implements UserService {

  private String roleName;

  public NormalServiceImpl(String roleName) {
    this.roleName = roleName;
  }

  @Override
  public String op() {
    return roleName + ":normal user operate......";
  }
}
