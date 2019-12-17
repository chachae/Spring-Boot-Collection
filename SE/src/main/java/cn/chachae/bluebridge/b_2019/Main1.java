package cn.chachae.bluebridge.b_2019;

/**
 * 第三题：数列求值 题目描述
 *
 * <p>给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和。求 第 20190324 项的最后 4 位数字。 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一 个 4 位整数（提示：答案的千位不为 0），在提交答案时只填写这个整数，填写 多余的内容将无法得分。
 * ———————————————— 版权声明：本文为CSDN博主「方小傑」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_42069140/article/details/89318297
 */

/**
 * @author chachae
 * @date 2019/11/22 10:59
 */
public class Main1 {

  public static void main(String[] args) {
    cal();

    int i =1;
  }

  private static void cal() {
    int n = 2019;
    int num = 0;
    for (int i = 1; i < n; i++) {
      if ((i + "").contains("2") || (i + "").contains("4")) {
        continue;
      }
      for (int j = i + 1; j < n; j++) { 
        if ((j + "").contains("2") || (j + "").contains("4")) {
          continue;
        }
        int k = n - i - j;
        if (i == k || j == k || i == j) {
          continue;
        }
        if (k > 0 && !(k + "").contains("2") && !(k + "").contains("4")) {
          num++;
        }
      }
    }
    System.out.println(num / 3);
  }
}
