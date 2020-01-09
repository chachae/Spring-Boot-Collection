package com.chachae.exception.handler.model;

import com.chachae.exception.handler.constant.REnum;
import com.chachae.exception.handler.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author chachae
 * @since 2020/1/9 9:10
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

  private Integer code;
  private String msg;
  private String time;
  private T data;

  /**
   * 成功返回结果
   *
   * @param t 泛型对象
   * @param <T> 泛型返回对象
   * @return T
   */
  public static <T> Result<T> ok(T t) {
    Result<T> result = new Result<>();
    result
        .setCode(REnum.SUCCESS.getCode())
        .setMsg(REnum.SUCCESS.getMsg())
        .setTime(DateUtil.now())
        .setData(t);
    return result;
  }

  /**
   * 失败返回结果
   *
   * @param t 泛型对象
   * @param <T> 泛型返回对象
   * @return T
   */
  public static <T> Result<T> fail(T t) {
    Result<T> result = new Result<>();
    result
        .setCode(REnum.FAIL.getCode())
        .setMsg(REnum.FAIL.getMsg())
        .setTime(DateUtil.now())
        .setData(t);
    return result;
  }
}
