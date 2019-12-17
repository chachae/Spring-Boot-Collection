package cn.chachae.se.exp4.q2;

/**
 * ①编写一个“游客”（YouKe）类：成员变量包括name、age；成员方法包括构造方法（带两个参数分别给name和age初始化），<br>
 * 以及buy方法，该方法可根据age的不同取值来输出对应的门票价格：18岁以上（包括18）价格50；12-18之间门票半价：25； 12岁以下（包括12）门票免费；<br>
 * ② 创建一个Test类作为主类，在main方法中，创建YouKe类的对象，实参（姓名和年龄）要求来自键盘的输入，<br>
 * 然后调用该对象的buy方法输出需要购买的门票价格。<br>
 */
class YouKe {

  private String name;
  private Integer age;

  YouKe(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  void buy() {
    if (age >= 18) {
      System.out.println(name + "的票价为：" + 50 + "元");
    } else if (age >= 12) {
      System.out.println(name + "的票价为：" + 25 + "元");
    } else {
      System.out.println(name + "的门票免费");
    }
  }
}
