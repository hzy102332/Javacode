package lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Determineexist {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter your number:");
		
		int n=s.nextInt();
		
			ifexist(n);
			
		}
		
	public static void ifexist(int n) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i =1;i<=100000;i++ ) {
			list.add(i);
			}	
			boolean t =false;
			long start =System.currentTimeMillis();
			try {
			
			for (int i =0;i<list.size();i++) {
				if (n==list.get(i)) {
					t=true;
					break;
				}
				
			}
			if (t) {
				System.out.println("Your number is in this arry!");
				}
			else {System.out.println("Your number is not in this arry!");}
			}
			catch (NoSuchElementException e){
			}
			long end = System.currentTimeMillis();
			long interval = end - start;

	System.out.println("The runnig time is£º" +interval+ " ms");
		
	}
}
