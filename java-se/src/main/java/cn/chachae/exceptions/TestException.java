package cn.chachae.exceptions;

import cn.hutool.core.lang.Console;
import org.junit.Test;

/**
 * @author chachae
 * @since 2019/12/24 19:27
 */
public class TestException {

  @Test
  public void test2() {
    int[] a = new int[5];
    Console.log(a);
  }

  @Test
  public void test1() {
    try {
      System.out.println("try block......");
    } finally {
      System.out.println("finally block......");
    }
  }
}
