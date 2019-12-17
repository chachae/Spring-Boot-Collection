package cn.chachae.se.exp4.q4;

class Circular {

  private double area;
  private double h;

  Circular(double area, double h) {
    this.area = area;
    this.h = h;
  }

  /**
   * 计算圆锥体积
   *
   * @return 体积
   */
  double getVolume() {
    return area * h / 3;
  }
}
