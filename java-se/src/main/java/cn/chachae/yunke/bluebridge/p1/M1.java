package cn.chachae.yunke.bluebridge.p1;

import java.util.Scanner;

/**
 * 十转十六
 *
 * @author chachae
 * @date 2019/10/18 18:01
 */
public class M1 {

  public static void main(String[] args) {
    System.out.println("请输入一个10进制数：");
    Scanner sc = new Scanner(System.in);
    String num = sc.next();
    int start = Integer.parseInt(num) / 16;
    String strStart = String.valueOf(start);
    int end = Integer.parseInt(num) % 16;
    String strEnd = String.valueOf(end);
    switch (strEnd) {
      case "10": strEnd = "A";break;
      case "11": strEnd = "B";break;
      case "12": strEnd = "C";break;
      case "13": strEnd = "D";break;
      case "14": strEnd = "E";break;
      case "15": strEnd = "F";break;
      default:break;
    }
    System.out.printf("%S", strStart + strEnd);
  }
}
