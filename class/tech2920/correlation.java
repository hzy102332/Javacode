package tech2920;

import java.util.Scanner;

public class correlation {
	public static void main(String[]args) {
//		analysis 1 
		int a = 1;
		System.out.println(a);
//		analysis 2
		Scanner s = new Scanner (System.in);
//		analysis 3
		System.out.print("Please enter a number:");
//		analysis 4
		int b = s.nextInt();
//		analysis 5
		b = b+a;
//		analysis 6
		System.out.println("The sum is:"+b);
//		analysis 7 
		for (int i = 1;i<10;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
//		analysis 8 
		while (a<10) {
			System.out.print(a+" ");
			a++;
		}
		System.out.println();
//		analysis 9
		if (a >10) {
			System.out.println("a is greater than 10.");
		}
		else {
			System.out.println("a is lower than 10.");
		}
//		analysis 10
		int [] c= new int [10];
		
	}
}















