package Classwork;

import java.util.Scanner;

public class abswork {
	public static void main(String[]args) {
		int pa;
		int time;
		double a;
		Bank b; 
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Principal Amont: ");
		pa=in.nextInt();
		System.out.print("Enter Time in years: ");
		time=in.nextInt();
		b=new ICBC(); 
		System.out.println("Simpleinterest for ICBC: "+pa*(1+time*b.getRateofinterest()/100));
		b=new BOC();
		System.out.print("Simpleinterest for BOC: "+pa*(1+time*b.getRateofinterest()/100));
	}
}
abstract class Bank{
	abstract double getRateofinterest();
}
class ICBC extends Bank{
	double getRateofinterest() {return 7.8;};
}
class BOC extends Bank {
	double getRateofinterest() {return 8.3;};
}