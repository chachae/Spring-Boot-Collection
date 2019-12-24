package cn.chachae.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chachae
 * @date 2019/11/28 19:58
 */
public class AopTest {

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("AopConfig.xml");
    Object bean = ctx.getBean("authService1");
    if (bean instanceof AuthService) {
      ((AuthService) bean).login();
      ((AuthService) bean).download();
    }
  }
}
