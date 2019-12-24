package cn.chachae.yunke.bluebridge.p3;

import java.util.Scanner;

/**
 * 最小公倍数
 *
 * @author chachae
 * @date 2019/11/6 11:34
 */
public class M2 {
  private static int gcd(int a, int b) { // 欧几里得算法求最大公约数
    return b == 0 ? a : gcd(b, a % b);
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(), b = input.nextInt();
    System.out.println(a / gcd(a, b) * b);
  }
}
