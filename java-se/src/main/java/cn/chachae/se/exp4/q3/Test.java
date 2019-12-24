package cn.chachae.se.exp4.q3;

import java.util.Scanner;

public class Test {

  public static void main(String[] args) {
    System.out.println("请输入账户名：");
    Scanner sc = new Scanner(System.in);
    // 账户名
    String accountName = sc.next();
    // 账户余额，默认 10000 元
    double money = 10000;
    // 创建 Account 对象
    Account ac = new Account(accountName, money);
    if (accountName != null) {
      System.out.println("存款选择：1，取款选择：2");
      int selectId = sc.nextInt();
      // 1 -> 存款
      if (selectId == 1) {
        System.out.println("请输入存入金额：");
        double saveMoney = sc.nextDouble();
        ac.cun(saveMoney);
      }
      // 2 -> 取款
      else {
        System.out.println("请输入取出金额：");
        double getMoney = sc.nextDouble();
        if (money < getMoney) {
          System.out.println("余额不足！");
        } else {
          ac.qu(getMoney);
        }
      }
    }
  }
}
