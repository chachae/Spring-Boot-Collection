package cn.chachae.se;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author chachae
 * @date 2019/12/9 15:03
 */
public class ExampleListData1 {
  public List<String> listAll() {
    List<String> list = Lists.newArrayList();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    return list;
  }

  @Test
  public void remove() {
    List<String> list = listAll();
    // 加锁
    ListIterator<String> iter = list.listIterator();
    while (iter.hasNext()) {
      String elem = iter.next();
      if ("4".equals(elem)) {
        list.remove(elem);
      }
    }
    // output the new list data
    System.out.println(Arrays.toString(list.toArray()));
  }
}
