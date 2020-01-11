package com.chachae.rest.template.api.controller;

import cn.hutool.json.JSONUtil;
import com.chachae.rest.template.api.model.User;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Stream;

/**
 * @author chachae
 * @since 2020/1/11 22:09
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

  private static final Map<Integer, User> DB = Maps.newHashMap();

  static {
    DB.put(1, User.builder().id(1L).name("Joe").age("20").build());
    DB.put(2, User.builder().id(2L).name("Rick").age("18").build());
    DB.put(3, User.builder().id(3L).name("Mike").age("22").build());
    DB.put(4, User.builder().id(4L).name("Sue").age("21").build());
    DB.put(5, User.builder().id(5L).name("Lua").age("19").build());
    DB.put(6, User.builder().id(6L).name("Lisa").age("25").build());
  }

  @GetMapping("/list")
  public String listAll() {
    return JSONUtil.toJsonStr(DB);
  }

  @GetMapping("/{id}")
  public String getByIdWithParam(@PathVariable Integer id) {
    User user = DB.get(id);
    return JSONUtil.toJsonStr(user);
  }

  @PostMapping("/delete")
  public String getByIdWithPath(@RequestParam Integer[] ids) {
    Stream.of(ids).forEach(DB::remove);
    return JSONUtil.toJsonStr(DB);
  }

  @PostMapping("/insert")
  public String getByIdWithJson(@RequestBody User user) {
    Integer key = Integer.valueOf(String.valueOf(user.getId()));
    DB.put(key, User.builder().id(user.getId()).name(user.getName()).age(user.getAge()).build());
    return JSONUtil.toJsonStr(DB.get(key));
  }
}
