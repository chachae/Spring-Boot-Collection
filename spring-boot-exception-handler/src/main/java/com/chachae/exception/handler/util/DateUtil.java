package com.chachae.exception.handler.util;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @author chachae
 * @since 2020/1/9 9:27
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
