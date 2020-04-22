package com.chachae.security.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * (Role)表实体类
 *
 * @author chachae
 * @since 2020-04-22 12:25:23
 */
@Data
public class Role {

  @TableId
  private Long id;

  private String name;

  private String sn;

}