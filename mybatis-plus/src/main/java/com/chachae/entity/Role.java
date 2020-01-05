package com.chachae.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @author chachae
 * @date 2019/12/18 13:34
 */
@TableName(value = "t_role")
@EqualsAndHashCode(callSuper = false)
@Data
public class Role extends Model<Role> {

  @TableId(type = IdType.AUTO)
  private Long id;

  @NotEmpty(message = "角色名不能为空")
  private String name;

  private String description;
}
