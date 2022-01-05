package Class;

import java.util.Scanner;

public class Trycatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter two integers");
		a=sc.nextInt();
		b=sc.nextInt();
		try{
		c=a/b;
		System.out.println("Result :"+c);
		}
		catch(ArithmeticException ex) {
			System.out.println("Exception caught:  Division zero");
		}
	}
}
