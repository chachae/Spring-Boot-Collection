package cn.chachae.se.extend.test.exp6;

/**
 * @author chachae
 * @date 2019/11/1 9:50
 */
public class Cylinder extends Circle {

  private double h;

  Cylinder(double x, double y, double r, double h) {
    super(x, y, r);
    this.h = h;
  }

  @Override
  public void show() {
    super.show();
  }

  /** 圆柱表面积 */
  @Override
  public double getArea() {
    double area = super.getArea();
    return Math.PI * 2 * r + area * 2;
  }

  /** 圆柱体积 */
  double getVolumn() {
    return Math.PI * Math.pow(r, 2) * h;
  }
}
