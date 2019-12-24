package cn.chachae.se.extend.test.exp4;

/**
 * @author chachae
 * @date 2019/11/1 15:20
 */
public class Cylinder extends Circle {

  private double area;
  private double h;

  private Cylinder(double r, double h) {
    super(r);
    this.h = h;
  }

  private double getVolme() {
    this.area = super.getArea();
    return this.area * this.h;
  }

  public static void main(String[] args) {
    Cylinder cylinder = new Cylinder(10, 10);
    System.out.printf("圆柱体体积：%.2f", cylinder.getVolme());
  }
}
