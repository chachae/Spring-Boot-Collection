package cn.chachae.se.exp4.q4;

import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    System.out.println("请输入半径：");
    Scanner sc = new Scanner(System.in);
    double r = sc.nextDouble();
    System.out.println("请输入高：");
    double h = sc.nextDouble();
    Circle circle = new Circle(r);
    Circular circular = new Circular(circle.getArea(), h);
    System.out.println("圆半径：" + r);
    System.out.println("圆锥体积：" + circular.getVolume());
  }
}
