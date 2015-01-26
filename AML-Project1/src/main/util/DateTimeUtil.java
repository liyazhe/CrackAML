package util;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class DateTimeUtil {
	private final static String fmt="yyMMddHH";
	private final static DateTimeFormatter formatter = DateTimeFormat.forPattern(fmt).withZoneUTC();
public static DateTime parseStringToDateTime(String s)
{
	return formatter.parseDateTime(s);
}
}
