package cn.chachae.bluebridge;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 给定一个序列，每次询问序列中第l个数到第r个数中第K大的数是哪个。
 *
 * <p>输入格式 第一行包含一个数n，表示序列长度。
 *
 * <p>第二行包含n个正整数，表示给定的序列。
 *
 * <p>第三个包含一个正整数m，表示询问个数。
 *
 * <p>接下来m行，每行三个数l,r,K，表示询问序列从左往右第l个数到第r个数中，从大往小第K大的数是哪个。序列元素从1开始标号。
 *
 * <p>输出格式 总共输出m行，每行一个数，表示询问的答案。 样例输入 5 1 2 3 4 5 2 1 5 2 2 3 2 样例输出 4 2
 */
@Slf4j
public class Main {

  @Test
  public void t2() {
    // j-Ih-gfE-dCba 1 4 8
    // jIhg-fEd-Cb-a 4 8 11
    System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
  }

  public String reverseOnlyLetters(String S) {
    if (S.length() <= 1) {
      return S;
    }
    // 左右指针
    int pL = 0;
    int pR = S.length() - 1;
    StringBuilder sb = new StringBuilder();
    // 移动指针
    while (pL < S.length() && pR >= 0) {
      // 如果左端不是字符
      if (!isOkchar(S.charAt(pL))) {
        sb.append(S.charAt(pL));
        pL++;
        // 右端不是字符
      } else if (!isOkchar(S.charAt(pR))) {
        pR--;
      } else {
        // 都是字符
        sb.append(S.charAt(pR));
        pL++;
        pR--;
      }
    }
    // 指针没到头的话
    sb.append(S.substring(pL));
    return sb.toString();
  }

  public boolean isOkchar(char c) {
    return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
  }
}
