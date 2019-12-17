package cn.chachae.leetcode;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 示例 2:
 *
 * <p>输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * <p>来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * <p>输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。   请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * <p>来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chachae
 * @date 2019/11/17 22:09
 */
public class Exp3 {

  @Test
  public void test() {

    int nums = lengthOfLongestSubstring("abcabcbb");
    System.out.println(nums);
  }

  public int lengthOfLongestSubstring(String s) {
    int n = s.length(), ans = 0;
    Map<Character, Integer> map = new HashMap<>(16);
    for (int end = 0, start = 0; end < n; end++) {
      char alpha = s.charAt(end);
      if (map.containsKey(alpha)) {
        start = Math.max(map.get(alpha), start);
      }
      ans = Math.max(ans, end - start + 1);
      map.put(s.charAt(end), end + 1);
    }
    return ans;
  }
}
