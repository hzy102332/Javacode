package chapter13;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class date {
public static void main(String []args) {
	SimpleDateFormat df=new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	Calendar c =Calendar.getInstance();
	System.out.println(df.format(c.getTime()));
	System.out.println("ERA: "+c.get(Calendar.ERA));
	System.out.println("Day ofYear: "+c.get(Calendar.DAY_OF_YEAR));
	System.out.println("Month: "+c.get(Calendar.MONTH));
	System.out.println("Week of Month: "+c.get(Calendar.WEEK_OF_MONTH));
	System.out.println("Week of Year: "+c.get(Calendar.WEEK_OF_YEAR));
	System.out.println("Year: "+c.get(Calendar.YEAR));
	System.out.println("Date: "+c.get(Calendar.DATE));
	System.out.println("Day of Week: "+c.get(Calendar.DAY_OF_WEEK));
	System.out.println("Day of Month: "+c.get(Calendar.DAY_OF_MONTH));
	System.out.println("Day of Year: "+c.get(Calendar.DAY_OF_YEAR));
	System.out.println("AM. PM.: "+c.get(Calendar.AM_PM));
	System.out.println("Hour: "+c.get(Calendar.HOUR));
	System.out.println("Minute: "+c.get(Calendar.MINUTE));
	System.out.println("Second: "+c.get(Calendar.SECOND));
	System.out.println("MilliSecond: "+c.get(Calendar.MILLISECOND));
 }
}
