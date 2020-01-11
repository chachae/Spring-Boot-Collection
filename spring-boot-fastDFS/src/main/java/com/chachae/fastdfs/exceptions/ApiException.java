package com.chachae.fastdfs.exceptions;

import lombok.*;

/**
 * @author chachae
 * @since 2020/1/11 9:19
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
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

  public static ApiException systemError(String msg) {
    return ApiException.builder().msg(msg).build();
  }
}
