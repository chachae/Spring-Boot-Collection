package com.chachae.task.job;

import com.chachae.task.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author chachae
 * @since 2020/1/11 20:19
 */
@Slf4j
@Component
public class TaskJob {

  /** 每隔20s 执行一次 */
  @Scheduled(cron = "0/20 * * * * ?")
  public void taskOne() {
    log.info("【task 1】 : {}", DateUtil.now());
  }

  /** 从启动时间开始，间隔 5s 执行 固定间隔时间 */
  @Scheduled(fixedRate = 5000)
  public void taskTwo() {
    log.info("【task 2】 : {}", DateUtil.now());
  }

  /** 从启动时间开始，延迟 5s 后间隔 10s 执行 固定等待时间 */
  @Scheduled(fixedDelay = 10000, initialDelay = 5000)
  public void taskThree() {
    log.info("【task 3】 : {}", DateUtil.now());
  }
}
