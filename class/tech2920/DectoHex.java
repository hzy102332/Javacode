package tech2920;

import java.util.Scanner;

public class DectoHex {
	public static void main(String []args) {
		Scanner s = new Scanner (System.in);
		String [] Hex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		System.out.print("Please enter a decimal number:");
		int dec = s.nextInt();
		String hex ="";
		for (int i = 0 ; dec>0;i++) {
			int digit = dec/16;
			int remainder = dec%16;
			System.out.println(dec+"/16 ="+digit +"...."+Hex[remainder]);
			hex = Hex[remainder]+hex;
			dec = digit;
		}
			
			System.out.print("Convert the number input to Hexadecimal is: "+hex);
		
	}
}
