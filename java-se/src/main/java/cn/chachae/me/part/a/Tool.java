package cn.chachae.me.part.a;

import lombok.Data;

/**
 * @author chachae
 * @date 2019/10/29 14:21
 */
@Data
public class Tool {

  protected String toolType;

  public void getToolType(String toolType) {
    this.toolType = toolType;
    System.out.println(toolType);
  }
}
