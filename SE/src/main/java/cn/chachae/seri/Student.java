package cn.chachae.seri;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chachae
 * @date 2019/12/9 14:08
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Student extends BaseEntity {

    private Long id;

  private String name;

  private Integer code;
}
