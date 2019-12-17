package cn.chachae.me.part.itf;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chachae
 * @date 2019/11/7 20:10
 */
@Data
@AllArgsConstructor
public class Student {

  private int index;

  private Long id;

  private String username;

  private String password;

  private Integer role;
}
