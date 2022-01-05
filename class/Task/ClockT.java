package Task;

public class ClockT {
	private int hr;
	private int min;
	private String amPm;
	String day;
	String zero="";
	public ClockT(int h,int m,String ap) {
		hr=h;
		min=m;
		amPm=ap;
	}
	public void getHr(int h) {
		hr=h;
	}
	public void getMin(int m ) {
		min=m;
	}
	public void getAmPm(String ap) {
		amPm=ap; 
	}
	public void toprint() {
		 System.out.println(hr+":"+zero+min+" "+amPm+day);
	}
	public void Adv(int m) {
		int minute=m%60;
		int hour=(m+min)/60;
		hr=hr+hour;
		min=min+minute;
		if(hr>12) {
			hr=hr%12;
			if (amPm=="Am") {
				amPm="PM";}
				else {
					amPm="AM";}}
			else if (hr==12) {
			 if (amPm=="AM") {
					amPm="PM";}
				else {
					amPm="AM";}}
		if (min>60) {
			min=min-60;
		}
		else if (min<10) {
			zero="0";
		}
		int d=m/60/24;
		if(d==0) {
			day="";
		}
		else	day="("+d+" "+"day later)";
}

	public static void main(String[]args) {
		ClockT time=new ClockT(6,27,"PM");
		time.Adv(1+30+5+60+128+180+1440+21075);
		time.Adv(30);
		time.Adv(5);
		time.toprint();
	}
}
