package com.chachae.api.example.string;

/**
 * @author chachae
 * @since 2020/1/5 21:28
 */
public class StringDemo2 {

  public static void main(String[] args) {

    String s = "hello";
    String str = s.substring(1, 4);
    // str: ell
    System.out.println("str: " + str);
    char[] chars = {'h', 'e', 'l', 'l', 'o'};
    String str2 = String.valueOf(chars, 1, 3);
    // str2: ell
    System.out.println("str2: " + str2);
  }
}
