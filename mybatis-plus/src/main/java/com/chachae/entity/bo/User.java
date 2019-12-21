package com.chachae.entity.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * @author chachae
 * @date 2019/12/16 14:38
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_user")
public class User extends Model<User> {

  @TableId(type = IdType.AUTO)
  private Long id;

  @NotEmpty(message = "用户名不能为空")
  @Length(max = 20, message = "长度不能超过20")
  private String userName;

  private String password;
}
