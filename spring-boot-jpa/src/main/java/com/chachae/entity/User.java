package com.chachae.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author chachae
 * @since 2020/1/7 23:02
 */
@Data
@Entity
@Table(name = "t_user")
public class User {

  @Id
  // 主键生成策略：MYSQL自增ID
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String userName;

  private String password;

  private Integer admin;

  private Integer status;
}
