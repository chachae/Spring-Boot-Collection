package cn.chachae.constant;

import cn.hutool.core.lang.Console;
import org.junit.Test;

/**
 * @author chachae
 * @date 2019/12/9 13:24
 */
public class ConstsTest {

  @Test
  public void test() {

    String des = SeasonEnum.WINTER.des;
    int val = SeasonEnum.WINTER.val;

    Console.log("des:{}，val:{}", des, val);
  }
}
