package com.chachae.shardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 表实体类
 *
 * @author chachae
 * @since 2020-05-08 18:00:49
 */
@Data
@TableName("t_user")
public class User {

  private Integer id;

  @TableId
  private Long userId;

  private Integer gender;

}