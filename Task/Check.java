package Task;

import java.util.Scanner;

public class Check {
//	 static void Check(String obj) {
//		int a;
//		a=obj.indexOf("/");
//		if (a<=0)
//		   throw new Exception("the format is wrong");
//	}
	public static void main(String[]args) {
		String date;
		int m,d,y;
		String mm,dd,yy;
		boolean year;
		boolean value=true;
		System.out.println("Please enter a date to be checked");
		Scanner in =new Scanner(System.in);
		date=in.next();
//		Check(date);
		String a[]=date.split("/");
		mm=a[0];
		dd=a[1];
		yy=a[2];
		m=Integer.parseInt(mm);
		d=Integer.parseInt(dd);
		y=Integer.parseInt(yy);
		System.out.println("data is "+mm+":"+dd+":"+yy);
		System.out.println("Your date was "+mm+"/"+dd+"/"+yy);
		if (y%4==0 |y%400==0)
			year=true;
		else 
			year=false;
		if (m>12) {value=false;
			System.out.println("It is not a valid date.");
			System.out.println("The reason it is invalid: The month value is not from 1 to 12.");}
		else if(m<8) {
			if(m==2) {
				if (year&&d>29) {value=false;
					System.out.println("It is not a valid date.");
					System.out.println("The reason it is invalid: The day value is not from 1 to 29.");}
		        
				else if (!year&&d>28){value=false;
					System.out.println("It is not a valid date.");
					System.out.println("The reason it is invalid: The day value is not from 1 to 28.");}}
		   else if(m%2==0) {
			   if (d>30) {value=false;
				   System.out.println("It is not a valid date.");
				   System.out.println("The reason it is invalid: The day value is not from 1 to 30.");}}
		   else {
			   if (d>31) {value=false;
				   System.out.println("It is not a valid date.");
				   System.out.println("The reason it is invalid: The day value is not from 1 to 31.");}}
		}
		else if(m>=8) {
			if(m%2==0) {
				 if (d>31) {value=false;
					   System.out.println("It is not a valid date.");
					   System.out.println("The reason it is invalid: The day value is not from 1 to 31.");}
			}
			else 
				if (d>30) {value=false;
					   System.out.println("It is not a valid date.");
					   System.out.println("The reason it is invalid: The day value is not from 1 to 30.");}
		}
	    if (value)
		   System.out.println("It is a valid date.");
	    	
   }
}













