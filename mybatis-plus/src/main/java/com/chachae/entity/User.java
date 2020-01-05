package com.chachae.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * @author chachae
 * @date 2019/12/16 14:38
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@TableName("t_user")
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model<User> {

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @NotEmpty(message = "用户名不能为空")
  @Length(max = 20, message = "长度不能超过20")
  @TableField(value = "user_name")
  private String userName;

  @NotEmpty(message = "密码不能为空")
  private String password;

  // 是否为管理员
  @NotEmpty(message = "是否为管理员不能为空")
  private Boolean admin;

  // 状态
  private Boolean status;
}
