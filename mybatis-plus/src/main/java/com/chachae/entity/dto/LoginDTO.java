package com.chachae.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * @author chachae
 * @since 2019/12/21 12:03
 */
@EqualsAndHashCode(callSuper = false)
@Data
@TableName(value = "t_user")
public class LoginDTO extends Model<LoginDTO> {

  @NotEmpty(message = "用户名不能为空")
  @Length(max = 20, message = "长度不能超过20")
  @TableField("user_name")
  private String userName;

  @NotEmpty(message = "密码不能为空")
  @TableField("password")
  private String password;
}
