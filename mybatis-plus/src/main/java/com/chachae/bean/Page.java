package com.chachae.bean;

/**
 * @author chachae
 * @date 2019/12/17 13:09
 */
public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> {

  /** 修改默认Page 无参构造 */
  public Page() {
    super();
    this.setSize(5L);
  }
}
