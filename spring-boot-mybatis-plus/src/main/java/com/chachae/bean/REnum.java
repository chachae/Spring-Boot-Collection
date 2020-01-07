package com.chachae.bean;

import lombok.AllArgsConstructor;

/**
 * @author chachae
 * @date 2019/12/17 10:40
 */
@AllArgsConstructor
public enum REnum {

  // 接口请求成功
  SUCCESS(200, "API request success"),
  // 接口请求失败
  FAIL(400, "API request fail"),
  // 服务器异常
  SERVER_ERROR(500, "Internal Server Error");

  /** 取值 */
  private final Integer value;

  /** 取描述 */
  private final String desc;

  public Integer value() {
    return this.value;
  }

  public String desc() {
    return this.desc;
  }
}
