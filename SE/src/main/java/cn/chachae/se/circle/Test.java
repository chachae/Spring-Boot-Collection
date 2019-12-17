package cn.chachae.se.circle;

/**
 * ① 定义Circle类：成员变量包括半径r和面积area， 成员方法包括构造方 法（带参数用来初始化半径），getArea方法用来计算面积；
 * ②定义Circular类：成员变量包括底面积（用Circle类的对象来定义）和高，成员方法包括构造方法（带参数用来初始化底面积和高），
 * getVolume方法用来计算圆锥体积；（构造方法要求使用this来引用当前对象） ③创建Test类作为主类，在Main方法中创建Circle类和Circular类的对象，
 * 求得圆锥体积，并输出底面积半径及圆锥体积。
 *
 * @author chachae
 * @date 2019/10/16 12:47
 */
public class Test {

  /**
   * 主函数
   *
   * @param args 主函数入参
   */
  public static void main(String[] args) {
    Circle circle = new Circle(20);
    Circular circular = new Circular(circle.getArea(), 10);
    System.out.println("底面半径"+circle.r);
    System.out.println("底面积：" + circle.getArea());
    System.out.println("体积：" + circular.getVolume());
  }

  /** 这是一个【圆】的静态内部类 */
  static class Circle {
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

  /** 圆锥静态内部类 */
  static class Circular {

    // 定义成员变量1. 底面积 2. 高
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
}
