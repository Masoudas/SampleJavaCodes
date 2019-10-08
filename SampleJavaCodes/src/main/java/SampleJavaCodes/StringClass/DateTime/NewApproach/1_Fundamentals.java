/**
 * Beginning with JDK 8, a new approach is introduced in java, with the
 * following APIs:
 * 
 * java.time
 * java.time.chrono // Alternative calendares.
 * java.time.format // Supports data and time formatting
 * java.time.temporal   //  Extendeted date and time functionality
 * java.time.zone   // Time zones.
 * 
 */

package SampleJavaCodes.StringClass.DateTime.NewApproach;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

class BasicTime{
    public static void main(String[] args) {
        // These classes provide several methods for 
        // subtracting data and time, comparing and so forth.
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        
        // These objects are kind of string like things.
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);

        // if you want to format the date and time,
        // we use the ofLocalized methods of the DateTimeFormatter class.
        DateTimeFormatter dateF = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter timeF = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        DateTimeFormatter dateTimeF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        System.out.println(date.format(dateF));
        System.out.println(time.format(timeF));
        System.out.println(dateTime.format(dateTimeF));

    }
}