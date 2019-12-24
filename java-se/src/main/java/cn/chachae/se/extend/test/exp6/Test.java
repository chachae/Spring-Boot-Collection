package cn.chachae.se.extend.test.exp6;

/**
 * @author chachae
 * @date 2019/11/1 9:58
 */
public class Test {

  public static void main(String[] args) {
    Cylinder cylinder = new Cylinder(1, 2, 2, 2);
    cylinder.show();
    System.out.printf("圆柱体表面积：%.2f %n", cylinder.getArea());
    System.out.printf("圆柱体体积：%.2f", cylinder.getVolumn());
  }
}
