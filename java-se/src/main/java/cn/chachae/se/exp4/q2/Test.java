package cn.chachae.se.exp4.q2;

import java.util.Scanner;

public class Test {

  public static void main(String[] args) {
    System.out.println("请输入姓名：");
    Scanner sc = new Scanner(System.in);
    String name = sc.next();
    System.out.println("请输入年龄：");
    int age = sc.nextInt();
    YouKe yk = new YouKe(name, age);
    yk.buy();
  }
}
