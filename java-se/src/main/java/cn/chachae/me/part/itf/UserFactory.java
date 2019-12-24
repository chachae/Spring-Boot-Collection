package cn.chachae.me.part.itf;

import java.util.List;
import java.util.Map;

/**
 * @author chachae
 * @date 2019/11/7 20:07
 */
public abstract class UserFactory<T> {

  /**
   * 获取
   *
   * @return 信息列表
   */
  abstract List<T> get();

  /** 删除 */
  abstract void delete();

  /**
   * 增加
   *
   * @param t 增加的信息
   */
  abstract void insert(T t);

  /**
   * 修改
   *
   * @param t 修改的信息
   */
  abstract void modify(T t);

  /**
   * 获取索引信息
   *
   * @return 信息
   */
  abstract T getById();

  /**
   * 获取index和id组成的键值信息
   *
   * @return Map
   */
  abstract List<Map<Object, Object>> getIndexAndId();
}
