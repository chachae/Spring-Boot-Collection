package cn.chachae.spring.aop;

/**
 * @author chachae
 * @date 2019/11/28 19:49
 */
public class AuthServiceImpl implements AuthService {
  @Override
  public void login() {
    System.out.println("登录中......");
  }

  @Override
  public void download() {
    System.out.println("下载中......");
  }
}
