package cn.chachae.spring.aop;

/**
 * @author chachae
 * @date 2019/11/28 19:51
 */
public class PermissionVerify {

  public void auth() {
    System.out.println("AOP:校验中......");
  }

  public void save() {
    System.out.println("AOP:处理中......");
  }
}
