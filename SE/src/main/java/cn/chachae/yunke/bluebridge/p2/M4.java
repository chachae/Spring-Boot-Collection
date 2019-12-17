package cn.chachae.yunke.bluebridge.p2;

/**
 * 冒泡排序
 *
 * @author chachae
 * @date 2019/11/2 20:49
 */
public class M4 {

  public static void main(String[] args) {
    int[] list = {1, 2, 3, -10, 22, 50};
    int temp;
    for (int i = 0; i < list.length; i++) {
      for (int j = 0; j < i; j++) {
        if (list[j] > list[j + 1]) {
          temp = list[j];
          list[j] = list[j + 1];
          list[j + 1] = temp;
        }
      }
    }
    for (int i : list) {
      System.out.print(i + " ");
    }
  }
}
