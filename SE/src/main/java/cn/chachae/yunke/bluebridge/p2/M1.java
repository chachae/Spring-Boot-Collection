package cn.chachae.yunke.bluebridge.p2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author chachae
 * @date 2019/10/28 22:18
 */
public class M1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count = sc.nextInt();
    int[] intList = new int[count];
    for (int i = 0; i < count; i++) {
      intList[i] = sc.nextInt();
    }
    Arrays.sort(intList);
    for (int i : intList) {
      System.out.print(i + " ");
    }
  }
}
