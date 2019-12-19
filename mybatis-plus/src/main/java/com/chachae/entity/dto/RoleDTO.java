package com.chachae.entity.dto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chachae
 * @date 2019/12/19 13:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDTO extends Model<RoleDTO> {

  private String keyword;
}
