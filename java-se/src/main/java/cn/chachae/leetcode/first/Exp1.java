package cn.chachae.leetcode.first;

import java.util.*;

/**
 * 输入: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"] 输出: [ "cats and dog", "cat
 * sand dog" ]
 *
 * @author chachae
 * @date 2019/11/18 10:24
 */
public class Exp1 {

  public static void main(String[] args) {
    Set<Integer> set = new LinkedHashSet<>();
    set.add(11);set.add(11);set.add(22);set.add(22);set.add(33);set.add(33);
    set.add(44);set.add(44);set.add(55);set.add(55);set.add(66);set.add(66);
    set.add(77);set.add(77);
    System.out.println(set.toString());
  }
}
