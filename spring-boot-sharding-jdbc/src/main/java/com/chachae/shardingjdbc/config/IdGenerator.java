package com.chachae.shardingjdbc.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @author chachae
 * @since 2020/5/8 18:31
 */
public class IdGenerator {

  private IdGenerator(){}

  private static final Snowflake ID = IdUtil.createSnowflake(1, 1);

  public static Long getId() {
    return ID.nextId();
  }

}
