package com.chachae.bean;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.chachae.util.DateUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * @author chachae
 * @date 2019/12/17 10:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Result<T> extends Model<Result<T>> {

  private Integer code;
  private T data;
  private String msg;
  private String time;

  /**
   * 普通返回结果
   *
   * @param t 泛型对象
   * @param <T> 泛型返回对象
   * @return T
   */
  public static <T> Result<T> ok(T t) {
    Result<T> result = new Result<>();
    result.code = HttpStatus.OK.value();
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
}
