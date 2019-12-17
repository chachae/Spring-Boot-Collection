package com.demo.api.utils;

import cn.hutool.core.lang.Console;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.lang.reflect.Field;
import java.sql.SQLException;

/**
 * @author chachae
 * @date 2019/12/10 13:56
 */
public final class DbUtil {

  public static <T> void save(T t) {
    try {
      Db.use().insert(Entity.parse(t));
    } catch (SQLException e) {
      Console.error("error info: {}", e);
    }
  }

  public static <T> void remove(T t) {
    String className = t.getClass().getName().toLowerCase();
    try {
      Db.use().del(Entity.create(className).set("id", t));
    } catch (SQLException e) {
      Console.error("error info: {}", e);
    }
  }

  public static <T> void update(T t) {
    try {
      String className = t.getClass().getSimpleName().toLowerCase();
      Long param = (long) getParam(t);
      Db.use().update(Entity.create().parseBean(t), Entity.create(className).set("id", param));
    } catch (Exception e) {
      Console.error("error info: {}", e);
    }
  }

  private static <T> Object getParam(T t) {
    Object obj = null;
    Class<?> clazz = t.getClass();
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      if ("id".equals(field.getName())) {
        try {
          obj = field.get(t);
        } catch (IllegalAccessException e) {
          Console.error("error info: {}", e);
        }
      }
    }
    return obj;
  }
}
