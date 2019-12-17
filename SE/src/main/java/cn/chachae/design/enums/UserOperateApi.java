package cn.chachae.design.enums;

/**
 * @author chachae
 * @date 2019/12/10 9:25
 */
public class UserOperateApi {

  public String get(String roleName) {
    return UserOperateEnum.valueOf(roleName).op();
  }
}
