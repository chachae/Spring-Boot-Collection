package cn.chachae.me.part.thread;

/**
 * @author chachae
 * @date 2019/10/29 18:59
 */
public class ThreadB extends Thread {
  private final Object lock;

  ThreadB(Object lock) {
    super();
    this.lock = lock;
  }

  @Override
  public void run() {
    try {
      synchronized (lock) {
        for (int i = 0; i < 10; i++) {
          MyList.add();
          if (MyList.size() == 5) {
            lock.notify();
            System.out.println("已发出通知！");
          }
          System.out.println("添加了" + (i + 1) + "个元素!");
          Thread.sleep(1000);
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
