package com.chachae.security.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * (Permission)表实体类
 *
 * @author chachae
 * @since 2020-04-22 12:25:54
 */
@Data
public class Permission {

  @TableId
  private Long id;

  private String name;

  private String expression;

}