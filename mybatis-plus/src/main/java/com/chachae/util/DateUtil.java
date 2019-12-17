package com.chachae.util;

import org.joda.time.DateTime;
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
    LocalDateTime now = LocalDateTime.now();
    return FORMATTER.print(now);
  }

  public static Date nowDate() {
    LocalDateTime now = LocalDateTime.now();
    return now.toDate();
  }

  public static Date parse(String date) {
    DateTime dateTime = FORMATTER.parseDateTime(date);
    return dateTime.toDate();
  }
}
