package cn.chachae.me.name;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chachae
 * @date 2019/12/10 10:48
 */
@Data
public class Employee implements Serializable {

  private Long id;

  private String userName;

  private String password;

  private Integer roleCode;
}
