package com.raffaeleconforti.processdiscoverer.impl.util;

import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;

public class TimeConverter
{
  private static final DecimalFormat decimalFormat = new DecimalFormat(StringValues.b[123]);
  
  public static String convertMilliseconds(String number)
  {
    return convertMilliseconds(Double.parseDouble(number));
  }
  
  public static String convertMilliseconds(double milliseconds)
  {
    double seconds = milliseconds / 1000.0D;
    double minutes = seconds / 60.0D;
    double hours = minutes / 60.0D;
    double days = hours / 24.0D;
    double weeks = days / 7.0D;
    double months = days / 30.0D;
    double years = days / 365.0D;
    if (years > 1.0D) {
      return decimalFormat.format(years) + " yrs";
    }
    if (months > 1.0D) {
      return decimalFormat.format(months) + " mths";
    }
    if (weeks > 1.0D) {
      return decimalFormat.format(weeks) + " wks";
    }
    if (days > 1.0D) {
      return decimalFormat.format(days) + " d";
    }
    if (hours > 1.0D) {
      return decimalFormat.format(hours) + " hrs";
    }
    if (minutes > 1.0D) {
      return decimalFormat.format(minutes) + " mins";
    }
    if (seconds > 1.0D) {
      return decimalFormat.format(seconds) + " secs";
    }
    if (milliseconds > 1.0D) {
      return decimalFormat.format(milliseconds) + " millis";
    }
    return "instant";
  }
  
  public static String[] parseDuration(Double milliseconds)
  {
    double seconds = milliseconds.doubleValue() / 1000.0D;
    double minutes = seconds / 60.0D;
    double hours = minutes / 60.0D;
    double days = hours / 24.0D;
    double weeks = days / 7.0D;
    double months = days / 30.0D;
    double years = days / 365.0D;
    if (years > 1.0D) {
      return new String[] { decimalFormat.format(years), " yrs" };
    }
    if (months > 1.0D) {
      return new String[] { decimalFormat.format(months), " mths" };
    }
    if (weeks > 1.0D) {
      return new String[] { decimalFormat.format(weeks), " wks" };
    }
    if (days > 1.0D) {
      return new String[] { decimalFormat.format(days), " d" };
    }
    if (hours > 1.0D) {
      return new String[] { decimalFormat.format(hours), " hrs" };
    }
    if (minutes > 1.0D) {
      return new String[] { decimalFormat.format(minutes), " mins" };
    }
    return new String[] { decimalFormat.format(seconds), " secs" };
  }
}
