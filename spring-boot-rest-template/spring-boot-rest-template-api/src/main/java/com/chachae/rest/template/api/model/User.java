package com.chachae.rest.template.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chachae
 * @since 2020/1/11 22:04
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Long id;

  private String name;

  private String age;
}
