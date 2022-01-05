package Classwork;

public class WinterHoliday {
	private String name;
	private int day;
	private String month;
	public void WinterHolidday(String name, int day, String month) {
		this.name=name;
		this.day=day;
		this.month=month;
	}
	public static boolean isSameMonth(WinterHoliday w1,WinterHoliday w2) {
		if(w1.getMonth().equalsIgnoreCase(w2.getMonth()))
		    return true;
		else
			return false;
	}
	public String getName(){
		return name;
	}
	public void setName() {
		this.name=name;
	}
	public void setDay(int day) {
		this.day=day;
	}
	public int getDay() {
		return day;
	}
	public void setMonth() {
		this.month=month;
	}
	public String getMonth() {
		return month;
	}
	public static double AvgDate(WinterHoliday[]arry) {
		double sum=0;
		for(int i=0;i<arry.length;i++) {
			sum=sum+arry[i].getDay();
		}
		     return sum/arry.length;
		}
	         public static void main(String[]args) {
		}

}
