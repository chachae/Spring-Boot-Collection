package cn.chachae.se.rmao.t4;

/**
 * @author chachae
 * @date 2019/11/3 14:44
 */
public class Dog extends Animal {

  private String name;

  private Dog() {
    this.name = "defaultName";
  }

  public Dog(String name) {
    this.name = name;
  }

  public void say() {
    System.out.println("狗叫");
  }

  @Override
  public void print() {
    System.out.printf("名字：%s，颜色：%s %n", name, color);
  }
}
