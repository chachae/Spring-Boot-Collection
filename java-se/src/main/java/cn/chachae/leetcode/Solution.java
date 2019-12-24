package cn.chachae.leetcode;

import org.junit.Test;

/**
 * @author chachae
 * @date 2019/11/24 16:46
 */
public class Solution {

  @Test
  public void test() {
    int[] ints = {
      7, 6, 4, 3, 1, 7, 6, 4, 3, 91, 7, 6, 48, 3, 16, 7, 6, 84, 3, 1, 7, 6, 64, 3, 1, 17, 6, 4, 3,
      1, 7, 456, 4, 3, 1, 7, 6, 4, 3, 1, 71, 116, 4, 3, 1, 7, 66, 4, 33, 1, 7, 6, 4, 3, 1, 4, 34,
      15, 7, 6, 4, 3, 1, 7, 6, 4, 3, 1, 7, 6, 4, 3, 1, 75, 6, 4, 3, 1, 7, 6, 4, 3, 1, 7, 6, 4, 3, 1,
      7, 6, 4, 3, 1, 7, 6, 4, 3, 1, 7, 6, 4, 3, 1
    };
    // ：name = "saeed", typed = "ssaaedd"

    // name = "alex", typed = "aaleex"

    /**
     * 输入：name = "leelee", typed = "lleeelee" 输出：true 示例 4：
     *
     * <p>输入：name = "laiden", typed = "laiden" 输出：true
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/long-pressed-name
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    String[] strs = {"Hello", "Alaska", "Dad", "Peace"};
    System.out.println(countSegments(", , , , a, eaefa"));
  }


  public int countSegments(String s) {
    String base = " ";
    int count = 0;
    int len = s.length();
    for (int i = 0; i < len; i++) {
      boolean x = base.equals((s.charAt(i) + ""));
      if (x && i != 0) {
        if (!base.equals((s.charAt(i - 1) + ""))) {
          count++;
        }
      }
    }
    if (!base.equals(s.charAt(len-1) + "")) {
      count++;
    }
    return count;
  }
}
