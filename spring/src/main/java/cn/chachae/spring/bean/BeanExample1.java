package cn.chachae.spring.bean;

import cn.chachae.config.ConfigExample1;
import cn.chachae.entity.User;
import cn.hutool.core.lang.Console;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;
import java.util.Set;

/**
 * @author chachae
 * @date 2019/12/9 22:02
 */
public class BeanExample1 {

  /** AnnotationConfigApplicationContext */
  @Test
  public void test() {
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(ConfigExample1.class);
    User user = ac.getBean(User.class);
    System.out.println(user.toString());
  }

  /** ClassPathXmlApplicationContext */
  @Test
  public void test2() {
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("classpath:AopConfig.xml");
    ConfigExample1 config = context.getBean(ConfigExample1.class);
    System.out.println(config.user().toString());
  }

  @Test
  public void test3() {
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("classpath:AopConfig.xml");
    ConfigurableEnvironment env = context.getEnvironment();
    Map<String, Object> map = env.getSystemProperties();
    Set<Map.Entry<String, Object>> entries = map.entrySet();
    entries.forEach(o -> Console.log("{}:{}", o.getKey(), o.getValue()));
  }
}
