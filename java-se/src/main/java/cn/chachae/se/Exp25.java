package cn.chachae.se;

/**
 * 简明版比较，并计算最大值，最小值，平均值
 *
 * @author chachae
 * @date 2019/9/25 19:22
 */
public class Exp25 {

  public static void main(String[] args) {
    // 一个整型数组【此处用乱序的1~10，便于测试】
    int[] a = {1, 3, 2, 6, 10, 8, 7, 9, 4, 5};
    // 定义max，min，sum【初始化参数为数组a中的任意数值】
    int max = a[0];
    int min = a[1];
    int sum = 0;
    // 增加for循环数组a
    for (int value : a) {
      // 如果当前值比max大，把当前值赋值给max
      if (max < value) {
        max = value;
      }
      // 如果当前值比min小，把当前值赋值给min
      if (min > value) {
        min = value;
      }
      // 每循环一个数组a元素，做增加【sum = sum + value】
      sum += value;
    }
    // 输出
    System.out.println("sum : " + sum);
    System.out.println("max : " + max);
    System.out.println("min : " + min);
    // （float）=强转类型，提升精度
    System.out.println("avg : " + (float) sum / a.length);
  }
}
