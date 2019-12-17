package cn.chachae.yunke.bluebridge.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chachae
 * @date 2019/10/22 11:16
 */
public class M3Stand {
  public static void main(String[] args) throws IOException {
    BufferedReader input;
    input = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(input.readLine());
    for (int ii = 0; ii < n; ++ii) {
      // s1读取16进制字符串
      char[] s1 = input.readLine().toCharArray();
      // s2存储转换后的2进制字符串
      StringBuilder s2 = new StringBuilder();
      // 转换成2进制字符串
      for (char c : s1) {
        switch (c) {
          case '0':
            s2.append("0000");
            break;
          case '1':
            s2.append("0001");
            break;
          case '2':
            s2.append("0010");
            break;
          case '3':
            s2.append("0011");
            break;
          case '4':
            s2.append("0100");
            break;
          case '5':
            s2.append("0101");
            break;
          case '6':
            s2.append("0110");
            break;
          case '7':
            s2.append("0111");
            break;
          case '8':
            s2.append("1000");
            break;
          case '9':
            s2.append("1001");
            break;
          case 'A':
            s2.append("1010");
            break;
          case 'B':
            s2.append("1011");
            break;
          case 'C':
            s2.append("1100");
            break;
          case 'D':
            s2.append("1101");
            break;
          case 'E':
            s2.append("1110");
            break;
          case 'F':
            s2.append("1111");
            break;
          default:
            break;
        } // 如果s2的长度不是3的倍数，在s2字符串前补足够的0
      }
      while (s2.length() % 3 != 0) {
        s2.insert(0, "0");
      }
      s1 = s2.toString().toCharArray();
      int i = 0;
      while (i < s1.length && (s1[i] - '0') * 4 + (s1[i + 1] - '0') * 2 + (s1[i + 2] - '0') == 0) {
        // 前导0不输出
        i += 3;
      }
      if (i == s1.length) {
        // 如果i已经走到2进制字符串末尾，说明字符串表示的数字是0，输出0
        System.out.println("0");
      } else {
        // 3位一输出
        for (; i < s1.length; i += 3) {
          System.out.print((s1[i] - '0') * 4 + (s1[i + 1] - '0') * 2 + (s1[i + 2] - '0'));
        }
      }
      System.out.println();
      Memory.get();
    }
  }
}
