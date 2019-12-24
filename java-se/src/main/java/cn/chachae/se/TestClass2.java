package cn.chachae.se;

import java.util.Scanner;

/**
 * @author chachae
 * @date 2019/10/27 13:31
 */
public class TestClass2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 此处接收从键盘输入的String类型的值
    String str = sc.next();
      /**
       * - 我们都知道字符串的索引位置是从 0 开始的，也就是说 0 即是字符串的第一位
       * - String 提供了两个方法，用来获取对象的索引信息，他们有什么用呢，举个例子。
       * - 比如：我们从键盘输入了：123abc，那么此时如上的操作就使得 str 等于 = "123abc"
       * -                  数据：1 2 3 a b c
       *                    索引：0 1 2 3 4 5
       * - 利用 indexOf() 和 charAt() 两个方法来获取 str 中包含的信息
       * 1. indexOf：
       *    比如 System.out.println(indexOf("a")); -> 此时输出3
       *        - 意思是查找出 str 中包含 a 的位置
       *    比如 System.out.println(indexOf("1")); -> 此时输出0
       *        - 意思是查找出 str 中包含 1 的位置
       * 2. charAt：
       *    比如 System.out.println(charAt(0)); -> 此时输出1
       *        - 意思是获取 str 中所处位置 0 的数据
       *    比如 System.out.println(charAt(2)); -> 此时输出3
       *        - 意思是获取 str 中所处位置 3 的数据
       *
       * 如果你在 indexOf() 或者 charAt() 中输入的信息都不包含（数据不存在或者查出索引位置）
       * ，则一律输出 -1
       */
    int a = str.indexOf("a");
    char b = str.charAt(0);
    System.out.println(a);  //输出3
    System.out.println(b);  //输出1
  }
}
