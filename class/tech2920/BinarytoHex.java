package tech2920;

import java.util.Scanner;

public class BinarytoHex {
	public static void main(String[]args) {
		String [] Hex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		Scanner s = new Scanner (System.in);
		System.out.print("Please enter your Binary number:");
		String bin = s.next();
		String[] arry = bin.split("");
		int remainder, site = 0;
		if (arry.length%2==0) {
			site = arry.length/4;
			remainder = 4;}
		else {
			site = arry.length/4+1;
			remainder = arry.length%4;
		}
		int len =0;
		String result = "";
		for (int i = 1; i<=site; i++) {
			int sum=0;
			if (i==site) 
				len = remainder-1;
			else 
				len = 3;
			
			int num = arry.length- i*4;
			if (num<0)  
				num = 0;
			
			for (int j = 0; j<=len; j++) {
				
				sum = sum + (int) (Integer.parseInt(arry[num+j]))*(int)(Math.pow(2, len-j));
			}
			result = Hex[sum]+result;
		}
		
		System.out.print("Convert the number input to Hexadecimal is: "+result);
	}
}
