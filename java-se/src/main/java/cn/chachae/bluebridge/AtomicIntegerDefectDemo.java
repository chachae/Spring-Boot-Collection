package cn.chachae.bluebridge;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chachae
 * @date 2019/11/28 17:34
 */
public class AtomicIntegerDefectDemo {
  public static void main(String[] args) {
    defectOfABA();
  }

  static void defectOfABA() {
    final AtomicInteger atomicInteger = new AtomicInteger(1);

    Thread coreThread =
        new Thread(
            () -> {
              final int currentValue = atomicInteger.get();
              System.out.println(
                  Thread.currentThread().getName() + " ------ currentValue=" + currentValue);

              // 这段目的：模拟处理其他业务花费的时间
              try {
                Thread.sleep(300);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }

              boolean casResult = atomicInteger.compareAndSet(1, 2);
              System.out.println(
                  Thread.currentThread().getName()
                      + " ------ currentValue="
                      + currentValue
                      + ", finalValue="
                      + atomicInteger.get()
                      + ", compareAndSet Result="
                      + casResult);
            });
    coreThread.start();

    // 这段目的：为了让 coreThread 线程先跑起来
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Thread amateurThread =
        new Thread(
            () -> {
              int currentValue = atomicInteger.get();
              boolean casResult = atomicInteger.compareAndSet(1, 2);
              System.out.println(
                  Thread.currentThread().getName()
                      + " ------ currentValue="
                      + currentValue
                      + ", finalValue="
                      + atomicInteger.get()
                      + ", compareAndSet Result="
                      + casResult);

              currentValue = atomicInteger.get();
              casResult = atomicInteger.compareAndSet(2, 1);
              System.out.println(
                  Thread.currentThread().getName()
                      + " ------ currentValue="
                      + currentValue
                      + ", finalValue="
                      + atomicInteger.get()
                      + ", compareAndSet Result="
                      + casResult);
            });
    amateurThread.start();
  }
}
