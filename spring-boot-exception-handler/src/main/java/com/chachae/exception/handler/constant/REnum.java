package com.chachae.exception.handler.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应枚举
 *
 * @author chachae
 * @since 2020/1/9 9:04
 */
@Getter
@AllArgsConstructor
public enum REnum {

  // 请求成功
  SUCCESS("请求成功", 200),

  // 请求失败
  FAIL("请求失败", 400),

  // 服务器异常
  SEVER_ERROR("服务器异常", 500);

  private final String msg;

  private final Integer code;
}
