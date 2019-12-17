package cn.chachae.me.part.thread;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chachae
 * @date 2019/10/29 17:42
 */
class MyList {
  private static List<String> list = Lists.newArrayList();

  static void add() {
    list.add("anyString");
  }

  static int size() {
    return list.size();
  }
}
