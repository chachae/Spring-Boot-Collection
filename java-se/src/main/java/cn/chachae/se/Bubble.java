package cn.chachae.se;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chachae
 * @since 2019/12/26 14:41
 */
public class Bubble {

  @Test
  public void test2() {
    int[] a = {
      1, 2, 7356, 435340, 33, 334, 545, 435634634, 346346, 43634, 4366, 34634, 636, -4353456, 4356,
      436, -10, 66, 78, 100, 4, 20
    };
    int len = a.length;
    int temp;
    for (int i = 0; i < len - 1; i++) {
      for (int j = 0; j < len - 1; j++) {
        if (a[j] > a[j + 1]) {
          temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
        }
      }
    }
    System.out.println(Arrays.toString(a));
  }
}
