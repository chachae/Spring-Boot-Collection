package cn.chachae.yunke.bluebridge.p2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author chachae
 * @date 2019/11/2 20:43
 */
public class M3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();
    for (int i = sc.nextInt(); i != 0; i = sc.nextInt()) {
      list.add(i);
    }
    Collections.reverse(list);
    list.forEach(i -> System.out.print(i + " "));
  }
}
