package com.demo.api.entity;

import com.demo.api.bean.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author chachae
 * @date 2019/12/10 13:03
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends BaseEntity {

  public User(String username, String password, Integer role) {
    this.username = username;
    this.password = password;
    this.role = role;
  }

  private Long id;

  private String username;

  private String password;

  private Integer role;
}
