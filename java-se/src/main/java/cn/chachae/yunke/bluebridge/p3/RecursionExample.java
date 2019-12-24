package cn.chachae.yunke.bluebridge.p3;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author chachae
 * @date 2019/11/4 22:05
 */
public class RecursionExample {
  /** 从1到100相加： */
  @Test
  public void test() {
    System.out.println(m1(100));
  }

  @Test
  public void test2() {
    System.out.println(m2(5));
  }

  @Test
  public void test3() {
    System.out.println(m3(10));
  }

  /**
   * 1+.....100
   *
   * @param i
   * @return
   */
  public int m1(int i) {
    if (i == 1) {
      return 1;
    }
    return i + m1(i - 1);
  }

  /**
   * n! n的阶乘
   *
   * @param i
   * @return
   */
  public BigInteger m2(int i) {
    if (i == 1) {
      return BigInteger.ONE;
    }
    return BigInteger.valueOf(i).multiply(m2(i - 1));
  }

  /**
   * 斐波那契
   *
   * @param i 月份
   * @return
   */
  public int m3(int i) {
    if (i == 1 || i == 2) {
      return 1;
    } else {
      return m3(i - 2) + m3(i - 1);
    }
  }
}
