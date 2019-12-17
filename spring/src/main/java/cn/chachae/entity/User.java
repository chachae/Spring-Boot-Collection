package cn.chachae.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chachae
 * @date 2019/12/13 21:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

  private Long id;

  private String userName;
}
