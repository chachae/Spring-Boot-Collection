package cn.chachae.test;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author chachae
 * @date 2019/12/14 13:21
 */
public class TestCmd {

  @Test
  public void test() throws IOException {
    Runtime.getRuntime().exec("cmd  /c  start " + "https://blog.chachae.cn");
  }
}
