package basic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils
{
	public static void testUTCTime()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		// 1、取得本地时间：
		java.util.Calendar cal = java.util.Calendar.getInstance();
		System.out.println("LocalTime: " + sdf.format(cal.getTime()));
		
		// 2、取得时间偏移量：
		int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
		
		// 3、取得夏令时差：
		int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
		
		// 4、从本地时间里扣除这些差量，即可以取得UTC时间：
		cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		
		System.out.println("UTC Time1: " + sdf.format(cal.getTime()));
		
		TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
		Calendar cal2 = Calendar.getInstance(zone);
		System.out.println("UTC Time2: " + sdf.format(cal2.getTime()));
		
		System.out.println("UTC Time3: "
				+ sdf.format(new Date(System.currentTimeMillis())));
	}
	
	public static void testCalendar()
	{
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2001, 7, 1, 0, 0, 0);
		System.out.println(cal1.getTime());
		// 在当前的时区下，我们指定了时间是 8 月，显示 7
		System.out.println(cal1.get(Calendar.MONTH));
		// 在当前的时区下，我们指定了时间是 1 日，显示 1
		System.out.println(cal1.get(Calendar.DATE));
		// 在当前的时区下，我们指定了时间是 0 时，显示 0
		System.out.println(cal1.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal1.getTimeZone().getID());
		cal1.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		// 如果取消下面代码的注释，结果就和前面的一样
		//int save = cal1.get(Calendar.MILLISECOND); // 调用了get()/add()等方法，那么Calendar将锁定其所保存的millisecond值
		cal1.set(Calendar.MILLISECOND, 0); //???????
		
		System.out.println(cal1.getTime());
		System.out.println(cal1.getTimeZone().getID());
		// 由于实际保存的时间没有修改，在 GMT 下，由于时差，显示 6 （7月）
		System.out.println(cal1.get(Calendar.MONTH));
		// 在 GMT 下，由于时差，显示 31
		System.out.println(cal1.get(Calendar.DATE));
		// 由于更改了时区，在 GMT 下时间就会变成 16，8个小时时差
		System.out.println(cal1.get(Calendar.HOUR_OF_DAY));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		testCalendar();
//		long curMill = System.currentTimeMillis();
//		Date curDate = new Date(curMill);
//		System.out.println(curDate);
//		System.setProperty("user.timezone", "UTC");
//		System.out.println(curDate);
//		
//		Date date1 = new Date();
//		System.out.println(date1.getTime());
//		System.out.println(System.currentTimeMillis());
//		
//		System.setProperty("user.timezone", "UTC");
//		
//		Date date2 = new Date();
//		System.out.println(date2.getTime());
	}
}
