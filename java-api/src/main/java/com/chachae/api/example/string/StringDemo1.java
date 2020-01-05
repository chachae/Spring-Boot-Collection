package com.chachae.api.example.string;

/**
 * 通过创建对象赋值，是在堆内存中，直接赋值是在方区常量池中
 *
 * @author chachae
 * @since 2020/1/5 21:25
 */
public class StringDemo1 {

  public static void main(String[] args) {
    String s1 = "hello";
    String s2 = "hello";
    String s3 = new String("hello");
    String s4 = new String("hello");
    System.out.println("(s1 == s2) : " + (s1 == s2));
    System.out.println("(s1 == s3) : " + (s1 == s3));
    System.out.println("(s3 == s4) : " + (s3 == s4));
  }
}
