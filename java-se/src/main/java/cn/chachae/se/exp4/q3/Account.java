package cn.chachae.se.exp4.q3;

/**
 * ①创建Account类，包括成员变量name作为账户名，money作为账户余额（初始值通过构造方法初始化），<br>
 * 成员方法包括构造方法来完成成员变量的初始化，cun可以实现存款，qu方法可以实现取款；<br>
 * ② 创建Test类作为主类，创建Account类的对象，然后分别调用cun和qu的方法来模拟实现存款和取款。<br>
 *
 */
class Account {

  private String name;
  private double money;

  Account(String name, double money) {
    this.name = name;
    this.money = money;
  }

  void cun(double saveMoney) {
    money += saveMoney;
    System.out.println("账户：" + name + "，存入金额：" + saveMoney + "元，余额：" + money + "元");
  }

  void qu(double getMoney) {
    money -= getMoney;
    System.out.println("账户：" + name + "，取出金额：" + getMoney + "元，余额：" + money + "元");
  }
}
