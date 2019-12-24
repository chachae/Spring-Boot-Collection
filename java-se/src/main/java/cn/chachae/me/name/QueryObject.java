package cn.chachae.me.name;

import lombok.Data;

/**
 * @author chachae
 * @date 2019/12/10 10:54
 */
@Data
public class QueryObject extends BaseEntity {

  private Integer currentPage = 1;

  private Integer rows = 10;
}
