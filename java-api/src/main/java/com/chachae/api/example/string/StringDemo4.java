package com.chachae.api.example.string;

import java.util.Scanner;

/**
 * 模拟登录<br>
 * A: 定义两个字符串，存储已经存在的用户名和密码<br>
 * B: 键盘录入用户名和密码<br>
 * C: 比较账号和密码是否匹配，相等提示登陆成功，不同提示失败，并提示还有几次机会<br>
 *
 * @author chachae
 * @since 2020/1/5 21:28
 */
public class StringDemo4 {

  private static final String USERNAME = "admin";
  private static final String PASSWORD = "admin";

  public static void main(String[] args) {
    int count = 4;
    Scanner sc = new Scanner(System.in);
    while (count != 0) {
      System.out.print("账号：");
      String u = sc.next();
      System.out.println("密码：");
      String p = sc.next();
      if (u.equals(USERNAME) && p.equals(PASSWORD)) {
        System.out.println("登陆成功！");
        break;
      } else {
        count--;
        if (count != 0) {
          System.out.printf("还有%s次机会！\n", count);
        } else {
          System.out.println("机会用完，稍后重试！");
        }
      }
    }
  }
}
