package com.chachae.entity.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chachae
 * @date 2019/12/19 21:11
 */
@TableName(value = "t_permission")
@EqualsAndHashCode(callSuper = true)
@Data
public class Permission extends Model<Permission> {

  @TableId(type = IdType.AUTO)
  private Integer id;

  private String name;

  private String expression;
}
