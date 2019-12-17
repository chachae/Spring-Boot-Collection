package cn.chachae.constant;

/**
 * 枚举常量【博涵一个圈参构造，《阿里编程规约》P9】
 *
 * @author chachae
 * @date 2019/12/9 13:16
 */
public enum SeasonEnum {
  // 春天
  SPRING(1, "春天"),
  // 夏天
  SUMMER(2, "夏天"),
  // 秋天
  AUTUMN(3, "秋天"),
  // 冬天
  WINTER(4, "冬天");

  public int val;

  public String des;

  SeasonEnum(int val, String des) {
    this.val = val;
    this.des = des;
  }
}
