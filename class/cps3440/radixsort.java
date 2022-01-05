package cps3440;

import java.util.Arrays;
import java.util.Scanner;

public class radixsort {
	public static void main(String []args) {
		
		int number;
		System.out.print("Please enter the number of elements:");
		Scanner s = new Scanner(System.in);
		number = s.nextInt();
		int [] a = new int [number];
		
		for (int i =0; i<number; i++) {
			a[i] = (int) (Math.random()*100);
		}
		
		long start = System.currentTimeMillis();
		System.out.println("The original array: \n"+Arrays.toString(a));
		
		radixsort(a, 3);
		
		long end = System.currentTimeMillis();
		
		System.out.println("After sorted:\n"+ Arrays.toString(a)+"\n"+(end - start));
	
	}
	public static void radixsort(int [] a,int length) {
		
		int max;
		if (a.length < 10) {
			max =10;
		}else {
			max = a.length;
		}
		int [] count = new int [10];
		int [] bucket = new int [a.length];
		
		for (int k = 1 ;k < length; k++ ) {
			
			for (int i = 0; i < 10; i++) {
				count[i] = 0;
			}
			for (int i = 0; i < a.length; i++) {
				count[getnumber(a[i],k)]++;
			}
			for (int i = 1; i < 10; i++) {
				count[i] = count[i] + count[i-1];	
			}
			for (int i = a.length-1; i >= 0; i--) {
				int j = getnumber(a[i], k);
				bucket[count[j]-1] = a[i];
				count[j]--;
			}
			for (int i = 0; i < a.length; i++) {
				a[i] = bucket[i];
			}
		}
	}
	public static int getnumber (int a, int b) {
		int [] position = {1,10,100,1000};
		int c = (a%position[b] - a%position[b-1])/position[b-1];
		return c;
	}
}
