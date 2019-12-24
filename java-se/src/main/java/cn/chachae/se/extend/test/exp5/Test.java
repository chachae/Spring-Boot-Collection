package cn.chachae.se.extend.test.exp5;

/**
 * @author chachae
 * @date 2019/11/1 9:39
 */
public class Test {

  public static void main(String[] args) {
    Vehicle vehicle = new Vehicle("Tesla", "blue");
    Bus bus = new Bus("Benz", "yellow", 5);
    Car car = new Car("TOYOTA", "khaki", 30);
    // 调用三个对象的show()方法
    vehicle.show();
    bus.show();
    car.show();
  }
}
