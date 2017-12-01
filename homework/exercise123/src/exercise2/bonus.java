package exercise2;

public class bonus {

}
class MyDate{
	int year;
	int month;
	int day;
	static String[] strMonths = {"JAN","FEB","MAR","APR","MAY","JUL","JUN","AUG",
			"SEP","OCT","NOV","DEC"};
	static String[] strDays = {"MON","TUE","WEN","THU","FRI","STA","SUN"};
	static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public boolean isLeapYear(int year) {
		if(year % 400 == 0 || year % 4 ==0 && year % 100 != 0)
			return true;
		return false;
	}
	public boolean isVaildDate(int year, int month, int day) {
		if(1 > year || year > 9999)
			return false;
		if(1 > month || month > 12)
			return false;
		if(isLeapYear(year))
			if(month == 2)
				if(1 < day && day < 30)
					return true;
		if(1 > day || day > daysInMonth[month - 1])
			return false;
		return true;
	}
	
}