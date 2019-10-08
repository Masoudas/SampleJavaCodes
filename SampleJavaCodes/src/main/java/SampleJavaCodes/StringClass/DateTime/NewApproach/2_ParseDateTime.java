/**
 * We can parse date and time.
 * What it means is that break a given string of date and time into
 * the standard format. In other words, parsing is what we use
 * to read date and time, rather than create it!
 * 
 * 
 */

package SampleJavaCodes.StringClass.DateTime.NewApproach;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

class Parsing{
    public static void main(String[] args) {
        // We can parse a date time string for example, and if it's in the right format
        // it will be accepted. For example, 19-10-03T14:57:30.680124 is the correct format.
        LocalDateTime dateTime = LocalDateTime.parse("2019-10-03T14:57:30.680124");
        DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(dateTime.format(format));

        // So now as a second example, we define a specific format, and then give data and
        // time in this format. If the given data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d',' yyyy hh':'mm a");
        LocalDateTime dateTime1 = LocalDateTime.parse("Jun 21, 2019 08:30 AM", formatter);

        System.out.println(dateTime1);

        // We can also use the same pattern to show date and time.
        LocalDateTime dateTime2 = LocalDateTime.now();
        System.out.println(dateTime2.format(formatter));
        

    }
}