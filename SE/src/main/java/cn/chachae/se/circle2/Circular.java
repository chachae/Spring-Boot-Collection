package cn.chachae.se.circle2;

/**
 * @author chachae
 * @date 2019/10/16 13:06
 */
public class Circular {

  private double area;
  private double h;

  Circular(double area, double h) {
    this.area = area;
    this.h = h;
  }

  double getVolume() {
    return area * h / 3;
  }
}
