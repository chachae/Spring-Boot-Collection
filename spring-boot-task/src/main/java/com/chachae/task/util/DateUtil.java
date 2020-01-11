package com.chachae.task.util;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * 日期工具类
 *
 * @author chachae
 * @date 2019/12/17 10:46
 */
public class DateUtil {

  private static final DateTimeFormatter FORMATTER =
      DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

  public static String now() {
    return FORMATTER.print(LocalDateTime.now());
  }

  public static Date nowDate() {
    return LocalDateTime.now().toDate();
  }

  public static Date parse(String date) {
    return FORMATTER.parseDateTime(date).toDate();
  }
}
