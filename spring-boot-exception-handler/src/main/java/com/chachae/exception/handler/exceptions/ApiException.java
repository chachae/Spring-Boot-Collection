package com.chachae.exception.handler.exceptions;

import lombok.*;

/**
 * @author chachae
 * @since 2020/1/9 9:09
 */
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ApiException extends RuntimeException {

  private String msg;
  private Exception exception;

  /**
   * 参数异常
   *
   * @param msg 异常消息
   * @return 异常通知
   */
  public static ApiException argError(String msg) {
    return ApiException.builder().msg(msg).build();
  }

  /**
   * 系统异常
   *
   * @param msg 异常消息
   * @return 异常通知
   */
  public static ApiException systemError(String msg) {
    return ApiException.builder().msg(msg).build();
  }
}
