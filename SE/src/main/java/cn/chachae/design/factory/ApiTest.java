package cn.chachae.design.factory;

import cn.chachae.design.enums.RoleConsts;
import org.junit.Test;

/**
 * @author chachae
 * @date 2019/12/10 9:52
 */
public class ApiTest {

  @Test
  public void test() {
    System.out.println(RoleFactory.get(RoleConsts.ROLE_SUPER_ADMIN_CODE).op());
  }
}
