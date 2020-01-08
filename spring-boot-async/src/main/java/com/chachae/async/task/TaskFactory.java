package com.chachae.async.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author chachae
 * @since 2020/1/8 9:06
 */
@Slf4j
@Component
public class TaskFactory {

  /**
   * 异步任务
   *
   * @return AsyncResult
   */
  @Async
  public Future<Boolean> asyncTask() {
    execute("asyncTask", 3);
    return new AsyncResult<>(Boolean.TRUE);
  }

  /** 同步任务 */
  public void syncTask() {
    execute("syncTask", 5);
  }

  /**
   * 任务执行方法
   *
   * @param taskName 任务名称
   * @param time 执行时间
   */
  private void execute(String taskName, Integer time) {
    long start = System.currentTimeMillis();
    log.info("{} 开始执行，当前线程名称【{}】", taskName, Thread.currentThread().getName());
    try {
      TimeUnit.SECONDS.sleep(time);
    } catch (Exception ignored) {
    }
    long end = System.currentTimeMillis();
    Long executeTime = end - start;
    log.info(
        "{} 执行成功，当前线程名称【{}】，执行时长：{}ms", taskName, Thread.currentThread().getName(), executeTime);
  }
}
