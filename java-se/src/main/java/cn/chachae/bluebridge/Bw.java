package cn.chachae.bluebridge;

import java.util.*;

/**
 * @author chachae
 * @date 2019/11/20 10:18
 */
public class Bw {
  public static void main(String[] args) {
    Set<List<Integer>> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    list.add(11); list.add(11); list.add(22); list.add(22); list.add(33); list.add(33);
    list.add(44); list.add(44); list.add(55); list.add(55); list.add(66); list.add(77);
    list.add(77);
    set.add(list);

      System.out.println(set.toString());
  }
}
