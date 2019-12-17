package cn.chachae.se;

import java.util.Scanner;

/**
 * @author chachae
 * @date 2019/10/27 13:55
 */
public class TestC2 {
  public static void main(String[] args) {
    System.out.println("请输入星期几：");
    Scanner sc = new Scanner(System.in);
    char today = sc.next().charAt(0);
    switch (today) {
      case '1':
      case '3':
      case '5':
        System.out.println("工作");
        break;
      case '2':
      case '4':
      case '6':
        System.out.println("上课");
        break;
      default:
        System.out.println("休息");
        break;
    }
  }
}
