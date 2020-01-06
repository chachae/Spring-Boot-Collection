package com.chachae.api.example.system;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chachae
 * @since 2020/1/5 22:55
 */
public class SystemDemo1 {

  @Test
  public void test() {
    for (int i = 0; i < 5000; i++) {
      System.out.print(i);
      if (i == 10) {
        System.exit(0);
      }
    }
  }

  @Test
  public void test2() {
    new Demo();
    // 垃圾回收
    System.gc();
  }

  @Test
  public void test3() {
    int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] newArr = new int[arr.length];
    System.arraycopy(arr, 0, newArr, 0, arr.length);
    System.out.println(Arrays.toString(newArr));
  }

  static class Demo {
    @Override
    protected void finalize() throws Throwable {
      System.out.println("我被回收了");
    }
  }
}
