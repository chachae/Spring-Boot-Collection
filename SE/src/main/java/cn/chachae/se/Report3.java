package cn.chachae.se;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author chachae
 * @date 2019/9/25 21:20
 */
public class Report3 {

  /**
   * （1）Write a program：Output data which is divided by 3 and 5 within 1000, and 10 items every<br>
   * line. 输出1000以内能同时被3和5整除的所有数，每行输出10个数。
   */
  public static void exp1() {
    int j = 0;
    for (int i = 1; i <= 1000; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        j++;
        System.out.print(i + "  ");
        if (j % 10 == 0) {
          System.out.print("\n");
        }
      }
    }
  }

  /**
   * Write a program：to guess data which is input from the keyboard to whether in defined array.<br>
   * 猜数游戏：已知一个数列8，4，2，1，23，24，12（可自己定义），从键盘上任意输入一个数据，判断数列中是否包含此数<br>
   * ，如果包含就输出“恭喜您，猜中了！！！”，否则输出“不好意思，您猜错了！！！”
   */
  public static void exp2() {
    int[] a = {8, 4, 2, 1, 23, 24, 12};
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入一个数：");
    int b = sc.nextInt();
    for (int c : a) {
      if (c == b) {
        System.out.println("恭喜您，猜中了！！！");
      }
    }
    System.out.println("不好意思，您猜错了了！！！");
  }

  /**
   * Write a program：print the average score of the singer.<br>
   * 歌手打分：在歌唱比赛中，共有10位评委进行打分，在计算歌手得分时，<br>
   * 去掉一个最高分，去掉一个最低分，然后剩余的8位评委的分数进行平均，<br>
   * 就是该选手的最终得分。输入每个评委的评分，求某选手的得分。
   */
  public static void exp3() {
    // 初始化一个空的整型数值
    int[] a = new int[10];
    // 最大值
    int max = a[0];
    // 最小值
    int min = a[0];
    // 总和
    int sum = 0;
    // 输入的时候用空格分开
    System.out.println("请输入 10 位评委的分数：");
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 10; i++) {
      a[i] = sc.nextInt();
    }
    // 找出最大值和最小值并且将计算总和【包含最大致最小值】
    for (int value : a) {
      if (max < value) {
        max = value;
      }
      if (min > value) {
        min = value;
      }
      sum += value;
    }
    // 强转 float 提高结果精度，将总和减去最大、最小值/8
    System.out.println("最终得分: " + (float) (sum - max - min) / 8);
  }

  /**
   * Write a program：Sort and output a set of characters in ascending and descending order.<br>
   * 对一组乱序的字符（字符序列自己定义）进行升序和降序排序并输出。<br>
   * 使用Arrays.sort
   */
  public static void exp4() {
    Integer[] a = {1, 2, 66, 5, 12, 3, 4, 90, -1, 20, 44, 123};
    // 降序算法
    Arrays.sort(a, Collections.reverseOrder());
    System.out.println("降序：");
    for (Integer x : a) {
      System.out.print(x + " ");
    }
    System.out.print("\n");
    System.out.println("升序：");
    // 升序算法
    Arrays.sort(a);
    for (Integer x : a) {
      System.out.print(x + " ");
    }
  }

  /**
   * Write a program： 1) Accept an argument from the command line. 2) If the argument is 优 prints
   * Excellent. If the argument is 良 prints Good. If the argument is 中 prints Average. If the
   * argument is 不及格 prints Fail.
   */
  public static void exp5() {
    // 你可以的
  }

  /**
   * 主函数
   *
   * @param args 入参
   */
  public static void main(String[] args) {
    // exp1();
    // exp2();
    // exp3();
    exp4();
  }
}
