package cn.chachae.se.extend.test.exp4;

/**
 * @author chachae
 * @date 2019/11/1 15:18
 */
public class Circle {

  private double r;

  Circle(double r) {
    this.r = r;
  }

  public double getArea() {
    return Math.PI * Math.pow(this.r, 2);
  }
}
