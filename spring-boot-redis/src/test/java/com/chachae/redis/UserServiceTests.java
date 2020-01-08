package com.chachae.redis;

import com.chachae.reids.RedisApplication;
import com.chachae.reids.entity.User;
import com.chachae.reids.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 接口测试用例
 *
 * @author chachae
 * @since 2020/1/8 10:32
 */
@Slf4j
@SpringBootTest(classes = RedisApplication.class)
public class UserServiceTests {

  @Resource private UserService userService;

  @Test
  public void testGet() {
    User entity = this.userService.getById(1L);
    log.info("entity: {}", entity.toString());
    entity = this.userService.getById(1L);
    log.info("entity: {}", entity.toString());
  }

  @Test
  public void testSaveOrUpdate() {
    User user = new User(4L, "Rick");
    this.userService.saveOrUpdate(user);
    log.info("entity: {}", user.toString());
  }

  @Test
  public void testDelete() {
    Long id = this.userService.delete(4L);
    this.userService.delete(4L);
    log.info("id: {}", id);
  }
}
