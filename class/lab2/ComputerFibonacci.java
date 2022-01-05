package lab2;

import java.util.Scanner;

public class ComputerFibonacci {
	static int count=0;
	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		System.out.print("Enter ana index for a Fibonacci number: ");
		int index= s.nextInt();
		System.out.println("The Fibonacci number at index "+index+" is "+fib(index)+" \nThe method used "+count+"time(s).");
		
		
	}
	public static long fib(long index) {
		count+=1;
		if(index==0){
			return 0;
		}
		else if(index==1) {
			return 1 ;
		}
		else { 
			return fib(index -1)+fib(index- 2);
		}
		
	}
	
}
