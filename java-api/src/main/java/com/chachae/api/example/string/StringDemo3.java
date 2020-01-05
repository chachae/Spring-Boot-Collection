package com.chachae.api.example.string;

/**
 * @author chachae
 * @since 2020/1/5 21:28
 */
public class StringDemo3 {

  public static void main(String[] args) {
    String s1 = "hello";
    String s2 = "hello";
    String s3 = "Hello";
    // true
    System.out.printf("s1.equals(s2) -> %s\n", s1.equals(s2));
    // false
    System.out.printf("s1.equals(s3) -> %s\n", s1.equals(s3));
    // true
    System.out.printf("s1.equalsIgnoreCase(s3) -> %s\n", s1.equalsIgnoreCase(s3));
  }
}
