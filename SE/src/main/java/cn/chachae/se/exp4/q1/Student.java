package cn.chachae.se.exp4.q1;

import java.util.Arrays;
import java.util.OptionalDouble;

/**
 * 5名学生参加Java知识竞赛，输出比赛的平均成绩和最高成绩，要求：<br>
 * ① 创建Student类，包括成员方法avg用来求学生的平均成绩、max方法用来求最高成绩；<br>
 * ②创建一个Test类作为主类，在main方法中从键盘输入5位学生的决赛成绩并保存在数组中，<br>
 * 然后将该数组作为参数传递给Student对象的两个成员方法。<br>
 */
class Student {

  /**
   * 平均分
   *
   * @param score 五位同学的成绩
   */
  void avg(double[] score) {
    OptionalDouble average = Arrays.stream(score).average();
    // 判断入参是否为空
    if (average.isPresent()) {
      System.out.println("平均成绩：" + average.getAsDouble());
    }
  }

  /**
   * 最大值
   *
   * @param score 五位同学的成绩
   */
  void max(double[] score) {
    OptionalDouble max = Arrays.stream(score).max();
    if (max.isPresent()) {
      System.out.println("最高成绩：" + max.getAsDouble());
    }
  }
}
