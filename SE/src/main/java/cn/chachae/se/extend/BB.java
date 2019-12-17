package cn.chachae.se.extend;

import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * @author chachae
 * @date 2019/11/1 9:13
 */
@NoArgsConstructor
public class BB extends Dd {
  int b;

  public BB(int b) {
    this.b = b;
  }

  @Override
  @Test
  public void ff() {
    super.ff();
  }
}
