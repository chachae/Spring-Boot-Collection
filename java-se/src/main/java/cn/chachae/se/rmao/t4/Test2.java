package cn.chachae.se.rmao.t4;

import java.util.Scanner;

/**
 * @author chachae
 * @date 2019/11/3 14:57
 */
public class Test2 {

  /**
   * 4. 定义一个类，该类实现猜数字游戏：随机生成一个0~999的数， 然后用户输入一个数，程序返回输入的数是大于还是小于生成的数，直到用户输入的数等于生成的数为止，程序退出。 提示：
   * 1)Java中的输入需要用到Scanner类，可以上网搜索用法。2 )Java中生成随机数需要用到Random类，可以上网搜索用法。
   *
   * @param args
   */
  public static void main(String[] args) {
    // 随机生成
    double randomNum = Math.random() * 1000;
    int n = (int) randomNum;
    System.out.println(n);
    while (true) {
      Scanner sc = new Scanner(System.in);
      int var = sc.nextInt();
      if (var > n) {
        System.out.println("大于生成的数");
      } else if (var < n) {
        System.out.println("小于生成的数");
      } else {
        System.out.println("相等");
        break;
      }
    }
  }
}
