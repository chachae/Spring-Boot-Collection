package com.chachae.entity.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * @author chachae
 * @since 2019/12/21 12:03
 */
@Data
public class LoginDTO {

  @NotEmpty(message = "用户名不能为空")
  @Length(max = 20, message = "长度不能超过20")
  private String userName;

  @NotEmpty(message = "密码不能为空")
  private String password;

  @Length(min = 4, max = 4, message = "验证码长度异常")
  @NotEmpty(message = "验证码不能为空")
  private String captcha;
}
