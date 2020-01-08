package com.chachae.dubbo.api.entity;

import com.chachae.dubbo.api.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author chachae
 * @since 2020/1/8 16:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {

  private Long id;

  private String userName;
}
