package cn.chachae.yunke.bluebridge.p1;

import java.util.Scanner;

/**
 * 十六转八
 *
 * @author chachae
 * @date 2019/10/21 22:11
 */
public class M3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 获取输入的值
    int count = sc.nextInt();
    String[] numList = new String[count];
    for (int i = 0; i < count; i++) {
      // 接收数值
      String num = sc.next();
      // 转二进制
      String splitNum = split(num);
      numList[i] = splitNum;
      int s = two2Ten(numList[i]);
      System.out.println(s);
    }
    Memory.get();
  }

  private static int two2Ten(String num) {
    int length = num.length();
    // 头部需要连接0的个数
    int appendZeroNum = length % 3 - 1;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < appendZeroNum; i++) {
      sb.append(0);
    }
    num = sb.append(num).toString();
    int index = 0, end = 3, sum = 0;
    String str;
    int newStrLength = num.length();
    int forNum = newStrLength / 3;
    int zhiNum = forNum - 1;
    for (int i = 0; i < forNum; i++) {
      String subStr = num.substring(index, end);
      str = coverTen(subStr);
      int pow = (int) Math.pow(10, zhiNum) * Integer.parseInt(str);
      sum += pow;
      zhiNum--;
      index = end;
      end = end + 3;
    }
    return sum;
  }

  /**
   * 分离数值，转二进制
   *
   * @param num 入参
   * @return 分离后的参数
   */
  private static String split(String num) {
    // 数值长度
    int length = num.length();
    // 建立切割索引
    int index = 0, end = 1;
    // String拼装对象
    StringBuilder sb = new StringBuilder();
    // 循环转换2进制
    for (int i = 0; i < length; i++) {
      String subStr = num.substring(index, end);
      String twoNum = cover(subStr);
      index++;
      end++;
      sb.append(twoNum);
    }
    return sb.toString();
  }

  /**
   * 十六转二数据字典
   *
   * @param num 入参
   * @return 二进制值
   */
  private static String cover(String num) {
    num = num.toUpperCase();
    switch (num) {
      case "A":
        num = "1010";
        break;
      case "B":
        num = "1011";
        break;
      case "C":
        num = "1100";
        break;
      case "D":
        num = "1101";
        break;
      case "E":
        num = "1110";
        break;
      case "F":
        num = "1111";
        break;
      case "1":
        num = "0001";
        break;
      case "2":
        num = "0010";
        break;
      case "3":
        num = "0011";
        break;
      case "4":
        num = "0100";
        break;
      case "5":
        num = "0101";
        break;
      case "6":
        num = "0110";
        break;
      case "7":
        num = "0111";
        break;
      case "8":
        num = "1000";
        break;
      case "9":
        num = "1001";
        break;
      default:
        break;
    }
    return num;
  }

  private static String coverTen(String num) {
    switch (num) {
      case "000":
        num = "0";
        break;
      case "001":
        num = "1";
        break;
      case "010":
        num = "2";
        break;
      case "011":
        num = "3";
        break;
      case "100":
        num = "4";
        break;
      case "101":
        num = "5";
        break;
      case "110":
        num = "6";
        break;
      case "111":
        num = "7";
        break;
      default:
        break;
    }
    return num;
  }
}
