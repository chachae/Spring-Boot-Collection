package cn.chachae.se.extend.test.exp5;

/**
 * @author chachae
 * @date 2019/11/1 9:27
 */
public class Vehicle {

  /** 品牌 */
  String brand;

  /** 颜色 */
  String color;

  Vehicle(String brand, String color) {
    this.brand = brand;
    this.color = color;
  }

  public void show() {
    System.out.printf("品牌：%s，颜色：%s %n", brand, color);
  }
}
