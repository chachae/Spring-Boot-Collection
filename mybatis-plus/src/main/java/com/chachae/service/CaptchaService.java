package com.chachae.service;

/**
 * @author chachae
 * @since 2019/12/31 10:32
 */
public interface CaptchaService {

  /**
   * 获取验证码
   *
   * @return 验证码的base64 信息
   */
  String getCaptcha();

  /**
   * 验证验证码
   *
   * @param text 前端传过来的验证码
   * @return boolean
   */
  Boolean verify(String text);
}
