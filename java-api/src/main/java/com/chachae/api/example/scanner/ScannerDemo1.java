package com.chachae.api.example.scanner;

import java.util.Scanner;

/**
 * @author chachae
 * @since 2020/1/5 18:20
 */
public class ScannerDemo1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("输入一个整型值：");
    int i = sc.nextInt();
    System.out.println("i:" + i);
    System.out.println("输入一个字符串：");
    String str = sc.next();
    System.out.println("str: " + str);
  }
}
