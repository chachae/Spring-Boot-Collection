package cn.chachae.se.exp4.q1;

import java.util.Scanner;

public class Test {

  public static void main(String[] args) {
    double[] score = new double[5];
    System.out.println("请输入5位同学的成绩：");
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < score.length; i++) {
      score[i] = sc.nextDouble();
    }
    Student student = new Student();
    student.avg(score);
    student.max(score);
  }
}
