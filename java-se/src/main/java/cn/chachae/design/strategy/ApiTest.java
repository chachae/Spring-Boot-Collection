package cn.chachae.design.strategy;

import cn.chachae.design.enums.RoleConsts;
import cn.hutool.core.lang.Console;
import org.junit.Test;

/**
 * @author chachae
 * @date 2019/12/10 10:10
 */
public class ApiTest {

  private JudgeRole judgeRole = new JudgeRole();

  @Test
  public void test() {
    Console.log(judgeRole.judge(new SuperAdminServiceImpl(RoleConsts.ROLE_SUPER_ADMIN)));
  }
}
