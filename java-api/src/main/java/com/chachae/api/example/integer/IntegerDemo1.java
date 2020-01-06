package com.chachae.api.example.integer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author chachae
 * @since 2020/1/6 9:38
 */
public class IntegerDemo1 {

  public static void main(String[] args) {
    test2();
  }

  @Test
  public void test() {
    // 自动装箱 - Integer a = new Integer(10)
    Integer a = 100;
    // 自动拆箱 - int b = a.intValue()
    int b = a;
    System.out.printf("a: %s, b: %s", a, b);
  }

  public static void test2() {
    Scanner sc = new Scanner(System.in);
    double n = sc.nextDouble();
    double min = Math.pow(-2, 31);
    double max = Math.pow(2, 31) - 1;
    if (n >= min && n <= max) {
      System.out.println("Allow");
    } else {
      System.out.println("Not allow");
    }
  }

  /** 自动装箱拆箱典型案例 */
  @Test
  public void test3() {

    /*
    1. a.intValue + b.intValue
    2. 赋值给sum，再自动装箱
     */
    Integer a = 10;
    Integer b = 20;
    Integer sum = a + b;

    // List 只能存放对象，此处是用了自动装箱，使得它可以存放基本数据类型
    List<Integer> list = new ArrayList<>();
    list.add(1);
  }
}
