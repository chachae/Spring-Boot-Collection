package cn.chachae.me.part.thread;

import java.util.Date;

/**
 * @author chachae
 * @date 2019/10/29 17:43
 */
public class ThreadA extends Thread {

  private final Object lock;

  ThreadA(Object lock) {
    super();
    this.lock = lock;
  }

  @Override
  public void run() {
    try {
      synchronized (lock) {
        if (MyList.size() != 5) {
          System.out.println("wait begin " + new Date(System.currentTimeMillis()));
          lock.wait();
          System.out.println("wait end  " + new Date(System.currentTimeMillis()));
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
