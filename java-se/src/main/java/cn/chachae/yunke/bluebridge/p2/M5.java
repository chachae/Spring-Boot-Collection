package cn.chachae.yunke.bluebridge.p2;

import java.util.*;

/**
 * 1. 定义一个Animal类。 a) 定义两个属性，名字和颜色。
 * b) 定义两个构造方法，一个没有输入参数，给名字和颜色随便赋值，
 * 另一个输入参数，把输入参数的值赋给名字和颜色。
 * c)
 * 定义一个方法，打印它的名字和颜色。
 * d) 在另一个类中写一个main函数，在main函数中创建一个Animal的对象，并且调用它的方法。
 */
public class M5 {
  public static void main(String[] args) {
    Integer[] arr = {1, 2, 3, 5};
    List<Integer> list = new ArrayList<>(Arrays.asList(arr));
    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();
    list.add(input);
    Collections.sort(list);
    System.out.println(list.toString());
  }
}
