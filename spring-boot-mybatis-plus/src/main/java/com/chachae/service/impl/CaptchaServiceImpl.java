package com.chachae.service.impl;

import com.chachae.Constants.SysConsts;
import com.chachae.exceptions.ApiException;
import com.chachae.service.CaptchaService;
import com.chachae.util.HttpContextUtil;
import com.wf.captcha.SpecCaptcha;
import org.springframework.stereotype.Service;

/**
 * 验证码业务实现
 *
 * @author chachae
 * @since 2019/12/31 10:38
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

  @Override
  public String getCaptcha() {
    SpecCaptcha specCaptcha = new SpecCaptcha();
    specCaptcha.setLen(4);
    String text = specCaptcha.text();
    String base64 = specCaptcha.toBase64();
    // 存入session 中
    HttpContextUtil.setSession(SysConsts.CAPTCHA, text);
    return base64;
  }

  @Override
  public boolean verify(String text) {
    try {
      Object obj = HttpContextUtil.getSession(SysConsts.CAPTCHA);
      HttpContextUtil.removeSession(SysConsts.CAPTCHA);
      return text.equalsIgnoreCase(obj.toString());
    } catch (NullPointerException e) {
      throw ApiException.argError("验证码错误");
    }
  }
}
