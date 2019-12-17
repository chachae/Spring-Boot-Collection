package cn.chachae.security;

import cn.hutool.crypto.SecureUtil;
import org.junit.Test;

/**
 * @author chachae
 * @date 2019/12/10 12:46
 */
public class SecurityExample1 {

  @Test
  public void test() {

    String str = SecureUtil.md5("1");
    System.out.println(str);
  }
}
