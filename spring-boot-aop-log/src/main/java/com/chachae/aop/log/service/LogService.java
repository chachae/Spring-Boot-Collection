package com.chachae.aop.log.service;

/**
 * @author chachae
 * @since 2020/1/10 9:30
 */
public interface LogService {

  /**
   * 用于测试aop 请求日志信息的测试接口
   *
   * @param arg 测试参数
   * @return 测试参数
   */
  String getLog(String arg);
}
