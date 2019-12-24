package cn.chachae.bluebridge;

import java.util.Scanner;

/**
 * 圆面积
 *
 * @author chachae
 * @date 2019/9/26 22:07
 */
public class Exp4 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double r = input.nextDouble();
    System.out.printf("%.7f", Math.PI * r * r);
  }
}
