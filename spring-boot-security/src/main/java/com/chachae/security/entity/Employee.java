package com.chachae.security.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * (Employee)表实体类
 *
 * @author chachae
 * @since 2020-04-21 21:33:16
 */
@Data
public class Employee {

  @TableId
  private Long id;

  private String username;

  private String password;

  private String email;

  private Integer age;

  private Boolean admin;

  private Long deptId;

}