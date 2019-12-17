package com.chachae.entity.dto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chachae
 * @date 2019/12/17 11:18
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends Model<UserDTO> {

  /** 关键字 */
  private String keyword;

  /** 角色 */
  private Integer role;
}
