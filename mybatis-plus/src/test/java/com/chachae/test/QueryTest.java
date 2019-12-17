package com.chachae.test;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chachae.entity.bo.User;
import com.chachae.entity.dto.UserDTO;
import com.chachae.service.UserService;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author chachae
 * @date 2019/12/16 14:57
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class QueryTest {

  @Resource private UserService userService;

  @Test
  public void queryAll() {
    List<User> users = this.userService.list();
    users.forEach(Console::log);
  }

  @Test
  public void test2() {
    User user = this.userService.getById(3);
    List<User> list = this.userService.list(null);
    list.forEach(Console::log);
  }

  /**
   * QueryWrapper条件构造器
   *
   * <p>
   */
  @Test
  public void test3() {
    Map<String, Object> params = Maps.newHashMap();
    params.put("user_name", "kke");
    QueryWrapper<User> qw = new QueryWrapper<>();
    qw.allEq(params);
    List<User> list = this.userService.list(qw);
    if (ObjectUtil.isNotEmpty(list)) {
      list.forEach(Console::log);
    }
  }

  /** 分页 */
  @Test
  public void test4() {
    Page<User> page = new Page<>(1, 3);
    UserDTO dto = new UserDTO();
    IPage<User> info = this.userService.selectPage(page, dto);
    Console.log("当前页：{}", info.getCurrent());
    Console.log("总页数：{}", info.getPages());
    Console.log("总数据：{}", info.getTotal());
    info.getRecords().forEach(Console::log);
  }
}
