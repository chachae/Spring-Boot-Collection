package cn.chachae.se.exp10;

/**
 * @author chachae
 * @date 2019/11/6 19:42
 */
public class Test {
  public static void main(String[] args) {
    Son son = new Son();
    test(son);
  }

  public static void test(Father father) {
    father.print();
  }
}
