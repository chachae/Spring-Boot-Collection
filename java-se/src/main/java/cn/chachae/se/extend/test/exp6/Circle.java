package cn.chachae.se.extend.test.exp6;

/**
 * @author chachae
 * @date 2019/11/1 9:47
 */
public class Circle extends Point {
  double r;

  Circle(double x, double y, double r) {
    super(x, y);
    this.r = r;
  }

  /**
   * 计算圆面积
   *
   * @return 圆面积
   */
  public double getArea() {
    return Math.PI * Math.pow(r, 2);
  }
}
