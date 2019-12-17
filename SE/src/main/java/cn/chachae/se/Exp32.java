package cn.chachae.se;

import java.util.Scanner;

/**
 * @author chachae
 * @date 2019/9/18 18:42
 */
public class Exp32 {

  /**
   * 1. Input 2 int numbers from the keyboard<br>
   * (use class Scanner), sum them up, output the summed result.
   */
  public static void c1() {
    System.out.println("Please input 2 int number:");
    Scanner sc = new Scanner(System.in);
    int intOne = sc.nextInt();
    int intTwo = sc.nextInt();
    int sum = intOne + intTwo;
    System.out.println("The sum : " + sum);
  }

  /**
   * 2. Input 2 Strings from the keyboard (use class Scanner)<br>
   * print them in order (the longer in front).【打印他们，长的排前面】
   */
  public static void c2() {
    System.out.println("Input 2 Strings from the keyboard :");
    Scanner sc = new Scanner(System.in);
    String s1 = sc.next();
    String s2 = sc.next();
    // 比较两个String类型的数值哪个比较长，根据题目需求做出判断
    // 此处，如果s1的长度比s2长，则s1在前，s2在后，反之亦然
    if (s1.length() > s2.length()) {
      System.out.println("Output : " + s1 + "," + s2);
    } else {
      System.out.println("Output : " + s2 + "," + s1);
    }
  }

  /**
   * 3. 键盘上输入一百分制成绩，根据成绩判断等级。90分以上为优，<br>
   * 80-89为良，70-79为中，60-69为合格，60分以下为不合格,要求用嵌套的if…else语句实现
   */
  public static void c3() {
    // While(1) 可以实现永真【即死循环，方便我们输入不同的值进行程序测试】
    while (true) {
      System.out.println("请输入一个成绩：");
      Scanner sc = new Scanner(System.in);
      int grade = sc.nextInt();
      // 先判断输入的值是否低于0或大于100，是的话打印【数值不合法】的提示信息,否则输入数据合法，则进行判断
      if (grade < 0 || grade > 100) {
        System.out.println("请输入一个合法的成绩！");
      } else {
        if (grade >= 90) {
          System.out.println("优");
        } else if (grade >= 80) {
          System.out.println("良");
        } else if (grade >= 70) {
          System.out.println("中");
        } else if (grade >= 60) {
          System.out.println("合格");
        } else {
          System.out.println("不合格");
        }
      }
    }
  }

  /**
   * 4. 用switch语句实现：Input a String，then output grade width<br>
   * （从键盘接收一个字符，然后按照考试成绩的等级打印出百分制分数段。）<br>
   * A：90-100 B：80-89 C: 70-79 D： 60-69 E：<60
   */
  public static void c4() {
    System.out.println("请输入一个成绩：");
    Scanner sc = new Scanner(System.in);
    int grade = sc.nextInt();
    // 先判断输入的值是否低于0或大于100，是的话打印【数值不合法】的提示信息,否则输入数据合法，则进行判断
    if (grade < 0 || grade > 100) {
      System.out.println("请输入一个合法的成绩！");
    } else {
      // 将成绩除10得到该成绩的【十位】的数据
      int count = grade / 10;
      switch (count) {
        case 10:
        case 9:
          System.out.println("A");
          break;
        case 8:
          System.out.println("B");
          break;
        case 7:
          System.out.println("C");
          break;
        case 6:
          System.out.println("D");
          break;
        default:
          System.out.println("E");
          break;
      }
    }
  }

  /**
   * 5. 循环累加1~10<br>
   * 打印累加大于20的值
   */
  public static void c5() {
    // 定义初始累加和为0
    int sum = 0;
    // 使用for循环累加1~10的数值
    for (int i = 1; i <= 10; i++) {
      sum += i;
      // 如果和大于20，打印该值
      if (sum > 20) {
        System.out.println("累加大于20的值：" + sum);
      }
    }
  }

  /** 6. 求1~10的偶数和 【方法1：简单好理解】 */
  public static void c6() {
    // 定义初始累加和为0
    int sum = 0;
    // 使用for循环累加1~10的数值
    for (int i = 1; i <= 10; i++) {
      // 判断是否为偶数
      if (i % 2 == 0) {
        sum += i;
      }
    }
    System.out.println("1~10的偶数和为:" + sum);
  }

  /** 6. 求1~10的偶数和 【方法2：老师要求的方法，使用continue;】 */
  public static void c7() {
    // 定义初始累加和为0
    int sum = 0;
    // 使用for循环累加1~10的数值
    for (int i = 1; i <= 10; i++) {
      // 使用continue的话，此处是判断是否为奇数
      if (i % 2 != 0) {
        continue;
      }
      // 循环累加求和
      sum += i;
    }
    System.out.println("1~10的偶数和为:" + sum);
  }

  /**
   * 测试方法的主函数
   *
   * @param args 主函数的默认入参
   */
  public static void main(String[] args) {
    // 需要测试那个方法，就把对应方法的注释解开
    // c1();
    // c2();
    // c3();
    // c4();
    // c5();
    // c6();
    c7();
  }
}
