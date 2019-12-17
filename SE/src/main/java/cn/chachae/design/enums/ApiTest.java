package cn.chachae.design.enums;

import org.junit.Test;

/**
 * @author chachae
 * @date 2019/12/10 9:09
 */
public class ApiTest {

  /**
   * 模拟多态或者Spring 依赖注入 <br>
   * 实际开发不能这样子写
   */
  private UserOperateApi api = new UserOperateApi();

  @Test
  public void test() {
    System.out.println(api.get(RoleConsts.ROLE_ADMIN));
  }
}
