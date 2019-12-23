package com.chachae.entity.dto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chachae
 * @date 2019/12/20 14:43
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class DepartmentDTO extends Model<DepartmentDTO> {

  private String keyword;
}
