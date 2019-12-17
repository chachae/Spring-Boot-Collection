package cn.chachae.me.part.thread;

/**
 * @author chachae
 * @date 2019/10/29 19:00
 */
public class Run {

  public static void main(String[] args) {

    try {
      Object lock = new Object();

      ThreadA a = new ThreadA(lock);
      a.start();

      Thread.sleep(50);

      ThreadB b = new ThreadB(lock);
      b.start();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
