package cn.chachae.config;

import cn.chachae.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author chachae
 * @date 2019/12/13 21:45
 */
@Component
public class ConfigExample1 {

  @Bean
  public User user() {
    System.out.println("The bean has been inject.");
    return new User(1L, "J.O.E");
  }
}
