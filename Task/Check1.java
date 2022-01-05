package Task;

import java.util.Scanner;

public class Check1 {
	public static void main(String[] args) {
		System.out.println("Please enter a date to be checked");
		Scanner reader = new Scanner(System.in);
		String date = reader.next();
		int breakIndex = date.indexOf("/");
		String monthString = date.substring(0, breakIndex);
		int month = Integer.parseInt(monthString);
		String rest = date.substring(breakIndex+1);
		breakIndex = rest.indexOf("/");
		String dayString = rest.substring(0, breakIndex);
		String yearString = rest.substring(breakIndex+1);
		int day = Integer.parseInt(dayString);
		int year = Integer.parseInt(yearString);
		System.out.println("date is " + month + ":" + day + ":"+ year );
		boolean validDate = true;
		String message = "";
		if(day<1) {
		validDate = false;
		message = "The day value is less than one. ";
		}
		switch(month){
		case 2: // February
		boolean leapYear = (year%400 == 0) || ((year%4 == 0) && (year%100 != 0));
		if(leapYear && day>29){
		validDate = false;
		message = "The day value is greater than 29 in February in a leap year. ";
		} else if(!leapYear && day>28){
		validDate = false;
		message = "The day value is greater than 28 in February in a non leap year. ";
		}
		break;
		case 4: // April
		case 6: // June
		case 9: // September
		case 11: // November
		if(day>30) {
		validDate = false;
		message = "The day value is greater than 30 in a month with just 30 days. ";
		}
		break;
		case 1: // January
		case 3: // March
		case 5: // May
		case 7: // July
		case 8: // August
		case 10: // October
		case 12: // December
		if(day>31) {
		validDate = false;
		message = "The day value is greater than 31 in a month with just 31 days. ";
		}
		break;
		default:
		validDate = false;
		message = message + "The month value is not from 1 to 12. ";
		}
		System.out.println("Your date was " + date);
		if(validDate){
		System.out.println("It is a valid date.");
		} else {
		System.out.println("It is not a valid date.");
		System.out.println("The reason it is invalid: " + message);
		} }

}
