package cn.chachae.test;

import org.junit.Test;

/**
 * @author chachae
 * @date 2019/12/13 22:06
 */
public class StringTest {

  public void test2(String... str) {
    for (String s : str) {
      String trim = s.trim();
      System.out.println(trim);
    }
  }

  @Test
  public void test() {

    test2("     123123", "   uuu", "  qqq  ", "sss");
  }
}
