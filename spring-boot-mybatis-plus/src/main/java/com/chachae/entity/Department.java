package com.chachae.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author chachae
 * @date 2019/12/20 14:41
 */
@TableName(value = "t_department")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department extends Model<Department> {

  @TableId(type = IdType.AUTO)
  private Integer id;

  @NotNull
  @Length(max = 20, message = "长度不能超过15个字")
  private String name;

  @Length(max = 20, message = "部门简介不能超过20个字")
  private String description;
}
