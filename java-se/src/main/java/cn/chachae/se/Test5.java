package cn.chachae.se;

import java.util.Arrays;

/**
 * @author chachae
 * @date 2019/10/23 15:27
 */
public class Test5 {

  public static void main(String[] args) {
    ff2(2, 3, 55, 4, 88, 9, 0, 454);
  }

  private static void ff2(int... b) {
    Arrays.stream(b).sorted().forEach(System.out::println);
  }
}
