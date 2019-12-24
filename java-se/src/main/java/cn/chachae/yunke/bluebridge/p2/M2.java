package cn.chachae.yunke.bluebridge.p2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author chachae
 * @date 2019/11/2 20:32
 */
public class M2 {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 3; i++) {
      list.add(sc.nextInt());
    }
    Collections.sort(list);
    Collections.reverse(list);
    list.forEach(i -> System.out.print(i + " "));
  }
}
