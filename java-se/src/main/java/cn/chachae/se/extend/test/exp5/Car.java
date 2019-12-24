package cn.chachae.se.extend.test.exp5;

/**
 * @author chachae
 * @date 2019/11/1 9:27
 */
public class Car extends Vehicle {

  /** 可乘坐人数 */
  private Integer passengers;

  Car(String brand, String color, Integer passengers) {
    super(brand, color);
    this.passengers = passengers;
  }

  @Override
  public void show() {
    System.out.printf("品牌：%s，颜色：%s，可乘坐人数：%d人 %n", brand, color, passengers);
  }
}
