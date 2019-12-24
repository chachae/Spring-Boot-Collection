package cn.chachae.bluebridge;

import java.util.Scanner;

/**
 * 1+2+3+·····+n
 *
 * @author chachae
 * @date 2019/9/26 22:01
 */
public class Exp2 {

  public static void main(String[] args) {
    int sum = 0;
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    for (int i = 1; i <= a; i++) {
      sum += i;
    }
    System.out.println(sum);
  }
}
