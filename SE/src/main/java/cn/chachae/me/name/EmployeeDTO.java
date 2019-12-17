package cn.chachae.me.name;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chachae
 * @date 2019/12/10 10:54
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeDTO extends QueryObject {

  // 各种模糊条件 ......

  private String name;
}
