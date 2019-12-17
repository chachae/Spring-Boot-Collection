package cn.chachae.yunke.bluebridge.p3;

import java.util.Scanner;

/**
 * @author chachae
 * @date 2019/11/6 11:20
 */
public class M1 {

  public static void main(String[] args) {
    Integer num = m1(new Scanner(System.in).nextInt());
    if (num <= 10007) {
      System.out.println(num);
    } else {
      System.out.println(num % 10007);
    }
  }

  private static Integer m1(int i) {
    if (i == 1 || i == 2) {
      return 1;
    } else {
      return m1(i - 1) + m1(i - 2);
    }
  }
}
