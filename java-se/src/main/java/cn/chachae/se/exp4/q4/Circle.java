package cn.chachae.se.exp4.q4;

/**
 * 写程序计算圆锥体的体积，要求： <br>
 * ① 定义Circle类：成员变量包括半径r， <br>
 * 成员方法包括构造方法（带参数用来初始化半径），getArea( )方法用来计算面积； <br>
 * ② 定义Circular类：成员变量包括底面积（用Circle类的对象来定义）和高， 成员方
 * 法包括构造方法（带参数用来初始化底面积和高），getVolume方法用来计算圆锥体积；（构造方法要求使用this来引用当前对象）；<br>
 * ③ 创建Test类作为主类，在Main方法中创建Circle类和Circular类的对象，求得圆锥体积，并输出底面积半径及圆锥体积。
 */
class Circle {
  private double r;

  Circle(double r) {
    this.r = r;
  }

  /**
   * 计算面积
   *
   * @return 面积
   */
  double getArea() {
    return Math.PI * r * r;
  }
}
