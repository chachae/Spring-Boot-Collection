package com.chachae.api.example.string;

import org.junit.jupiter.api.Test;

/**
 * 1：遍历字符串(获取字符串中的每一个字符) <br>
 * 2：统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数。(不考虑其他字符)
 *
 * @author chachae
 * @since 2020/1/5 21:28
 */
public class StringDemo5 {

  @Test
  public void testA() {
    String str = "Hello12345World@@";
    char[] chars = str.toCharArray();
    for (char a : chars) {
      System.out.printf("%s ", a);
    }
  }

  @Test
  public void testB() {
    int b = 0, s = 0, n = 0;
    String str = "Hello12345World";
    char[] chars = str.toCharArray();
    for (char a : chars) {
      if (a >= 'a' && a <= 'z') {
        s++;
      } else if (a >= 'A' && a <= 'Z') {
        b++;
      } else if (a >= '0' && a <= '9') {
        n++;
      }
    }
    System.out.printf("大写字符个数：%s\n小写字符个数：%s\n数字字符个数：%s\n", b, s, n);
  }
}
