package sec02.verify.exam02;

import java.util.Calendar;

public class DatePrintExample {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR);
		
		int month = now.get(Calendar.MONTH) + 1;
		String strMonth = (month<10)? ("0"+month) : (""+month);
		
		int dayOfMonth = now.get(Calendar.DAY_OF_MONTH);
		String strDayOfMonth = (dayOfMonth<10)? ("0"+dayOfMonth) : (""+dayOfMonth);
		
		String[] dayArray = {"일", "월", "화", "수", "목", "금", "토"};
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		String strDayOfWeek = dayArray[dayOfWeek-1] + "요일";
		
		int hour = now.get(Calendar.HOUR_OF_DAY);
		String strHour = (hour<10)? ("0"+hour) : (""+hour);
		
		int second = now.get(Calendar.SECOND);
		String strSecond = (second<10)? ("0"+second) : (""+second);
		
		System.out.print(year + "년 ");
		System.out.print(strMonth + "월 ");
		System.out.print(strDayOfMonth + "일 ");
		System.out.print(strDayOfWeek + " ");
		System.out.print(strHour + "시 ");
		System.out.print(strSecond + "분 ");
	}
}
