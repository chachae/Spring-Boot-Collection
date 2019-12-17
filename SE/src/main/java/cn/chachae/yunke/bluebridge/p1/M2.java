package cn.chachae.yunke.bluebridge.p1;

import java.util.Scanner;

/**
 * 十六转十
 *
 * @author chachae
 * @date 2019/10/18 18:26
 */
public class M2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 获取输入的值
    String num = sc.next();
    // 循环切割输入的字符串，保存到新的数组
    String[] newNum = new String[num.length()];
    int index = 0, end = 1;
    for (int i = 0; i < num.length(); i++) {
      String subStr = num.substring(index, end);
      subStr = subStr.toUpperCase();
      // 转换数字
      switch (subStr) {
        case "A": subStr = "10";break;
        case "B": subStr = "11";break;
        case "C": subStr = "12";break;
        case "D": subStr = "13";break;
        case "E": subStr = "14";break;
        case "F": subStr = "15";break;
        default: break;
      }
      newNum[i] = subStr;
      index++;
      end++;
    }
    // 转换计算
    int sum = 0;
    // 指数
    int zhiNum = newNum.length - 1;
    for (String s : newNum) {
      int pow = Integer.parseInt(s) * (int) Math.pow(16, zhiNum);
      zhiNum--;
      sum += pow;
    }
    System.out.println(sum);
  }
}
