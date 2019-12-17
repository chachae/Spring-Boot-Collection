package com.chachae.bean;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chachae
 * @date 2019/12/17 12:37
 */
@Data
@NoArgsConstructor
public class PageResult<T> {

  /** 当前页 */
  private Long current;
  /** 数据总数 */
  private Long total;
  /** 页数 */
  private Long pages;
  /** 每页数据 */
  private Long size;
  /** 记录 */
  private List<T> records;

  protected static <T> PageResult<T> warp(IPage<T> iPage) {
    PageResult<T> result = new PageResult<>();
    result.current = iPage.getCurrent();
    result.total = iPage.getTotal();
    result.pages = iPage.getPages();
    result.size = iPage.getSize();
    result.records = iPage.getRecords();
    return result;
  }
}
