package cn.chachae.design.strategy;

/**
 * @author chachae
 * @date 2019/12/10 10:11
 */
public class JudgeRole {

  public String judge(UserService userService) {
    RoleContext roleContext = new RoleContext(userService);
    return roleContext.execute();
  }
}
