package cn.chachae.me.part.map;

import cn.hutool.core.lang.Console;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * @author chachae
 * @date 2019/12/10 10:30
 */
public class MapExample1 {

  @Test
  public void test() {

    Map<Integer, String> map = Maps.newHashMap();

    map.put(1, "a");
    map.put(2, "b");
    map.put(3, "c");
    map.put(4, "d");
    map.put(5, "e");

    Set<Map.Entry<Integer, String>> sets = map.entrySet();

    for (Map.Entry<Integer, String> set : sets) {
      System.out.println(set.getKey());
    }

    map.forEach((k, v) -> Console.log("{}:{}", k, v));
  }
}
