package cn.chachae.se;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author chachae
 * @date 2019/10/4 13:48
 */
public class T2 {

  public static void main(String[] args) {
      test3();
  }

  public static void test3() {
    // 初始化一个空的整型数值
    int[] a = new int[3];
    float p, s;
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 3; i++) {
      a[i] = sc.nextInt();
    }

    p = (a[0] + a[1] + a[2]) >> 1;
    s = (float) Math.sqrt(p * (p - a[0]) * (p - a[1]) * (p - a[2]));
    if ((a[0] + a[1] > a[2]) && (a[0] + a[2] > a[1]) && (a[1] + a[2]) > a[0]) {
      System.out.println(s);
    }
    System.out.println("No answer");
  }
}
