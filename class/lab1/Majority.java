package lab1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Majority {
	public static void main(String []args) {
		
		int count = 0;
		Scanner s = new Scanner (System.in);
		System.out.println("Please enter your arry:");
		String line= s.nextLine();
		String [] arry = line.split(",");
		int[] arr = new int[arry.length];
		for (int i = 0;i<arry.length;i++) {
			arr[i]=Integer.parseInt(arry[i]);
			count+=1;
		}
		
		long start =System.currentTimeMillis();
		try {
		majority(arr);
		}
		catch (NoSuchElementException e){
		}
		long end = System.currentTimeMillis();
		long interval = end - start;
		
		System.out.println("The runnig time is£º" +interval+ " ms");
		
		}
	public static void majority(int []arr) {
			int majnumber = 0;
			int [] majority= new int [100];
			int c =arr.length;
			for (int i = 0;i<arr.length;i++) {
				majority[arr[i]] += 1;
			}
			for (int i=0; i<majority.length;i++) {
				if (majority[i]>c/2) {
					majnumber+=1;
				}
			}
			if (majnumber>0) {
		System.out.println("There is(are) exisis: "+majnumber+" majority element."+"\n"+"The element as follow:");
		
		}
		else {
			System.out.println("There is no majority element.");
		} 
		for(int i=0; i<majority.length; i++) {
			if (majority[i]>c/2) {
				System.out.println(i);
				}
			}
	}
}

