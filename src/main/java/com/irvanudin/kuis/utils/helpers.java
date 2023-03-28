package com.irvanudin.kuis.utils;

import java.time.LocalDate;
import org.springframework.format.datetime.standard.DateTimeFormatterFactory;

public class helpers {
  public static String getDateNow() {
    LocalDate now = LocalDate.now();
    DateTimeFormatterFactory formatterFactory = new DateTimeFormatterFactory("dd/MM/yyyy");
    return now.format(formatterFactory.createDateTimeFormatter());
  }
}
