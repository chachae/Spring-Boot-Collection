package cn.chachae.me.name;

import java.util.List;

/**
 * 分页结果集
 *
 * @author chachae
 * @date 2019/12/10 10:53
 */
public class PageResult<T> extends BaseEntity {

  /** 当前页 */
  private Integer currentPage;

  /** 数据总数 */
  private Long count;

  /** 总页数 */
  private Integer totalPage;

  /** 数据 */
  private List<T> items;
}
