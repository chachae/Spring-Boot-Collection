package cn.chachae.pattern.singleton;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chachae
 * @date 2019/11/11 22:33
 */
public class ThreadPoolService {
  private static final int DEFAULT_CORE_SIZE = 100;
  private static final int MAX_QUEUE_SIZE = 500;
  private static volatile ThreadPoolExecutor executor;

  private ThreadPoolService() {};

  /** 获取单例的线程池对象 */
  public static ThreadPoolExecutor getInstance() {
    if (executor == null) {
      synchronized (ThreadPoolService.class) {
        if (executor == null) {
          executor =
              new ThreadPoolExecutor(
                  // 核心线程数
                  DEFAULT_CORE_SIZE,
                  // 最大线程数
                  MAX_QUEUE_SIZE,
                  // 闲置线程存活时间
                  Integer.MAX_VALUE,
                  // 时间单位
                  TimeUnit.MILLISECONDS,
                  // 线程队列
                  new LinkedBlockingDeque<Runnable>(Integer.MAX_VALUE),
                  // 线程工厂
                  Executors.defaultThreadFactory());
        }
      }
    }
    return executor;
  }

  public void execute(Runnable runnable) {
    if (runnable == null) {
      return;
    }
    executor.execute(runnable);
  }

  /**
   * 从线程队列中移除对象
   *
   * @param runnable
   */
  public void cancel(Runnable runnable) {
    if (executor != null) {
      executor.getQueue().remove(runnable);
    }
  }
}
