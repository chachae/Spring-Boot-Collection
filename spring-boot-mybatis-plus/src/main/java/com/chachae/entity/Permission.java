package com.chachae.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

/**
 * @author chachae
 * @date 2019/12/19 21:11
 */
@TableName(value = "t_permission")
@EqualsAndHashCode(callSuper = false)
@Data
public class Permission extends Model<Permission> {

  @TableId(type = IdType.AUTO)
  private Integer id;

  @Length(max = 20, message = "部门名称不能超过10个字")
  private String name;

  private String expression;
}
