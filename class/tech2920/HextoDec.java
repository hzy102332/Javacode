package tech2920;

import java.util.Scanner;

public class HextoDec {
	public static void main(String []args) {
		Scanner s = new Scanner (System.in);
		System.out.print("Please enter the base you want to converts: ");
		int base = s.nextInt();
		System.out.print("Please enter your number:");
		String hex = s.next();
		String [] arry = hex.split("");
		int pow = arry.length-1;
		int sum=0;
		int num=0;
		for (int i = 0; i<=pow; i++ ) {
			
			if (arry[i].matches("\\d")) {
				num =(int) (Integer.parseInt(arry[i]));
			}
			else {
				num = letter(arry[i]);
			}
			if (i == pow) {
			System.out.print(num+"*"+base+"^"+(pow-i));
			}
			else
				System.out.print(num+"*"+base+"^"+(pow-i)+"+");
			sum =sum + num*(int)(Math.pow(base, pow-i));	
		}
		
		System.out.print("\nConvert the number input to Decimal is: "+sum);
		
	}
	public static int letter(String l) {
		int a=0;
		switch (l) {
		case "A":
			a = a + 10;
			break;
		case "B":
			a = a + 11;
			break;
		case "C":
			a = a + 12;
			break;
		case "D":
			a = a + 13;
			break;
		case "E":
			a = a + 14;
			break;
		case "F":
			a = a + 15;
			break;
	}
		return a;

	}
}
