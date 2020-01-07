package com.chachae.api.example.calendar;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

/**
 * @author chachae
 * @since 2020/1/5 23:10
 */
public class CalendarDemo {

  @Test
  public void test() {
    Calendar calendar = Calendar.getInstance();
    int a = calendar.get(Calendar.YEAR);
    int b = calendar.get(Calendar.MONTH) + 1;
    int c = calendar.get(Calendar.DAY_OF_MONTH);
    System.out.println(a + "年" + b + "月" + c + "日");
  }
}
