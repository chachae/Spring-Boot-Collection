package com.chachae.reids.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chachae
 * @since 2020/1/8 9:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String userName;
}
