package cn.chachae.design.strategy;

/**
 * @author chachae
 * @date 2019/12/10 10:09
 */
public class RoleContext {

  private UserService userService;

  public RoleContext(UserService userService) {
    this.userService = userService;
  }

  public String execute() {
    return userService.op();
  }
}
