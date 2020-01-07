package com.chachae.bean;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.chachae.util.DateUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author chachae
 * @date 2019/12/17 10:27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Result<T> extends Model<Result<T>> {

  private Integer code;
  private String msg;
  private String time;
  private T data;

  /**
   * 普通返回结果
   *
   * @param t 泛型对象
   * @param <T> 泛型返回对象
   * @return T
   */
  public static <T> Result<T> ok(T t) {
    Result<T> result = new Result<>();
    result.code = REnum.SUCCESS.value();
    result.msg = REnum.SUCCESS.desc();
    result.time = DateUtil.now();
    result.data = t;
    return result;
  }

  /**
   * 分页结果集
   *
   * @param t 泛型对象
   * @param <T> 泛型返回对象
   * @return T
   */
  @SuppressWarnings("unchecked")
  public static <T> Result<T> ok(IPage<T> t) {
    Result<T> result = new Result<>();
    result.code = REnum.SUCCESS.value();
    result.msg = REnum.SUCCESS.desc();
    result.time = DateUtil.now();
    result.data = (T) PageResult.warp(t);
    return result;
  }

  public static <T> Result<T> fail(T t) {
    Result<T> result = new Result<>();
    result.code = REnum.FAIL.value();
    result.msg = REnum.FAIL.desc();
    result.time = DateUtil.now();
    result.data = t;
    return result;
  }

  public static <T> Result<T> fail(T t, Integer code) {
    Result<T> result = new Result<>();
    result.code = code;
    result.msg = REnum.FAIL.desc();
    result.time = DateUtil.now();
    result.data = t;
    return result;
  }
}
