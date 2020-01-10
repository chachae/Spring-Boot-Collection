package com.chachae.aop.log.service.impl;

import com.chachae.aop.log.service.LogService;
import org.springframework.stereotype.Service;

/**
 * @author chachae
 * @since 2020/1/10 9:43
 */
@Service
public class LogServiceImpl implements LogService {

  @Override
  public String getLog(String arg) {
    return arg;
  }
}
