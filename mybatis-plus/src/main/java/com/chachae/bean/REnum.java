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
  FAIL(500, "API request fail");

  /** 取值 */
  public final Integer val;

  /** 取描述 */
  public final String desc;
}
