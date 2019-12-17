package cn.chachae.se.circle2;

/**
 * @author chachae
 * @date 2019/10/16 13:06
 */
public class Circle {
  private double r;

  /**
   * 半径构造
   *
   * @param r 半径
   */
  Circle(double r) {
    this.r = r;
  }

  /**
   * 获取圆锥底面积【圆面积】
   *
   * @return 面积大小
   */
  double getArea() {
    return Math.PI * r * r;
  }
}
