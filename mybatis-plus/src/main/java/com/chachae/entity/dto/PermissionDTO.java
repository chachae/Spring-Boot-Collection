package com.chachae.entity.dto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chachae
 * @date 2019/12/19 21:16
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PermissionDTO extends Model<PermissionDTO> {

  private String keyword;
}
