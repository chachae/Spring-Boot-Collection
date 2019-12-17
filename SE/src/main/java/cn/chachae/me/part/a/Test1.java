package cn.chachae.me.part.a;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Data;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author chachae
 * @date 2019/10/29 14:14
 */
@Data
public class Test1 {

  private int id;
  private String name;

  public Test1 readName(String name) {
    this.name = name;
    return this;
  }

  @Test
  public void test1() {
    String name = this.getClass().getName();
    System.out.println(name);
  }

  @Test
  public void test2() {
    Set<String> set = Sets.newHashSet();
    // 唯一，不重复
    set.add("a");
    set.add("b");
    set.add("c");
    set.forEach(System.out::println);

    List<Object> list = Lists.newArrayList();
    list.add("a");
    list.add("b");
    list.add("c");
    for (Object next : list) {
      System.out.println(next);
    }

    Map<Object, Object> map = Maps.newHashMap();
    map.put(null, "123");
    System.out.println(map.get(null));
  }
}
