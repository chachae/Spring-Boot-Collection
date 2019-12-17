package cn.chachae.se;

/**
 * 这是一个综合了排序以及计算的程序
 *
 * @author chachae
 * @date 2019/9/25 18:39
 */
public class Match {

  /**
   * 定义了一个main函数<br>
   * 我们都知道，main函数的默认入参数 String[] args，意思是：一个名为args的String类型数组
   *
   * @param args main函数的默认入参
   */
  public static void main(String[] args) {
    // 给String数组args定义10个参数
    args = new String[] {"2", "1", "3", "4", "6", "5", "7", "8", "10", "9"};
    // 定义一个整型数组a
    int[] a = new int[10];
    // for循环遍历10次，每循环一次就给数组a赋上args[i]的值一次，直到<10，【数组最后的下标=数组的长度-1】
    for (int i = 0; i < 10; i++) {
      // 给数组a[i]赋上args的值【 Integer.parseInt是一个可以将String转int的方法】
      a[i] = Integer.parseInt(args[i]);
    }
    // 到这里，上面的for循环就结束了，数组a已经拥有了数组args的所有值了
    // 定义最大、最小、总和三个int型值以及float类型的平均值avg，将数组a的第一个元素值赋给他们【相当于初始化这三个参数】
    int max = a[0], min = a[0], sum = a[0];
    float avg;
    // 开始一个新的for循环【10次】
    for (int i = 1; i < 10; i++) {
      // 通过if...else...循环来比较最大值和最小值，如果循环到的数组a的值比定义的值的初始化值大，则将循环到的值赋给max
      if (a[i] > max) {
        max = a[i];
      }
      // 同理循环来比较最大值和最小值，如果循环到的数组a的值比定义的值的初始化值小，则将循环到的值赋给min
      if (a[i] < min) {
        min = a[i];
      }
      // 计算总和
      // 相当于sum = a[0]+a[1]+a[2]+a[3]+a[4]+a[5]+a[6]+a[7]+a[8]+a[9]
      sum += a[i];
    }
    // 至此，循环结束
    System.out.println(sum);
    // 平均值 = 总和/10
    avg = sum / 10;
    System.out.println("max num : " + max);
    System.out.println("min num : " + min);
    System.out.println("avg num : " + avg);
  }
}
