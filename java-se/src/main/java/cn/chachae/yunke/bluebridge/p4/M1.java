package cn.chachae.yunke.bluebridge.p4;

import java.util.Scanner;

/**
 * 杨辉三角 eg：
 *
 * @author chachae
 * @date 2019/11/11 22:01
 */
public class M1 {

  /*
   * 1
   * 1 1
   * 1 2 1
   * 1 3 3 1
   * 1 4 6 4 1
   */

  public static void main(String[] args) {
    int n = new Scanner(System.in).nextInt();
    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          a[i][j] = 1;
        } else {
          a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
        }
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }
}
