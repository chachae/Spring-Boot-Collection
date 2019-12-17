package cn.chachae.se.person;

/**
 * @author chachae
 * @date 2019/10/9 19:00
 */
public class Person {

  /**
   * Person类的两个成员变量也就是Person类的两个属性<br>
   * 1. name：姓名<br>
   * 2. age：年龄
   */
  private String name;

  private int age;

  /** getter方法 */
  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
  /** setter方法 */
  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  /** 无参构造 1. 特点：不包含Person类的两个成员变量 2.有成员变量的入参 */
  public Person() {}

  /** 有参构造：包含了Person类的两个成员变量 */
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  /** 自己定义的方法 */
  public void introduction() {
    System.out.println("我叫" + name + "，今年" + age + "岁！");
  }

  /** 主函数 */
  public static void main(String[] args) {
    // 调用有参构造
    Person p1 = new Person("张三", 23);
    p1.introduction();

    // 调用无参构造
    Person p2 = new Person();
    p2.setAge(25);
    p2.setName("李四");
    p2.introduction();
  }

  /**
   * 一、说构造方法先来谈谈实体类<br>
   * 1. 构造方法最直观的表达体现在一种叫做"实体类"的类中，这种类不是什么特殊的类也没有特别的功能，只是为了具体化它的作用而约定好的别称<br>
   * 2. 实体类简单地说就是"一个存放了某样东西的信息的类"，比如这个Person类，他存放了Person的姓名和年龄，它就是一个实体类<br>
   *
   * 二、构造方法<br>
   * 1. 与实体类一样，构造方法也是一种普通的方法，它存在于实体类中有其特定的作用，即作为实体类成员属性数据的读或者取的桥梁<br>
   * 2. 构造方法通常有两类，无参构造方法和有参构造方法，从字面意思上看其实很好理解它的意思，有成员变量入参的无入参的区别~<br>
   *
   * 三、无参构造和有参构造的存在意义是什么？<br>
   * 1. 有参构造
   *    - 有参构造存在的入参包含了实体类的全部成员变量，我们给有参构造赋值的时候往往需要将全部参数填写到有参构造中
   *    - 综上，它的缺点就是比较死板，需要填写全部参数，但是成员变量少的时候是一个很好的存在【这个Person还体现不出来】
   * 2. 无参构造
   *    - 没有参数，自由度高的构造方法
   *    - 基于Person来讲，自由度高的体现，体现在我们可以不给 Person p2 = new Person() 这个对象设置参数，或说值只设置一个，或者全部设置，都是OK的，
   *    所以很自由
   */
}
