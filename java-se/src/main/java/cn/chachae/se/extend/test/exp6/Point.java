package cn.chachae.se.extend.test.exp6;

/**
 * @author chachae
 * @date 2019/11/1 9:44
 */
public class Point {

  private double x;
  private double y;

  Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void show() {
    System.out.printf("坐标(%.1f,%.1f) %n", x, y);
  }
}
