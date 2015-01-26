package util;

import org.joda.time.DateTime;

public class DateTimeUtilTest {
	public static void main(String[] args)
	{
		DateTime t=DateTimeUtil.parseStringToDateTime("14102100");
		System.out.println(t);
		System.out.println(t.getHourOfDay());
	}
}
