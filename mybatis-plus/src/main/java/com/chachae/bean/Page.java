package com.chachae.bean;

/**
 * @author chachae
 * @date 2019/12/17 13:09
 */
public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> {

  /** 修改默认Page 无参构造 */
  public Page() {
    // 父实现
    super();
    // 默认分页每页数据数
    this.setSize(5L);
  }
}
