package lab3;

import java.util.Scanner;

public class subsetsum {
	static int rest;
	public static void main (String[]args) {
		int [] subset = {1,2,3,4,5,6,7,8,9,10,12,14,16,18,20};
		int [] el =new int [15];
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter the number you want to check: ");
		int k=s.nextInt();
		rest=k;
		int count=0;
		for (int i =14; i>=0;i--) {
			int temp=rest;
			find(subset,i);
			if (temp!=rest) {
				el[count]=subset[i];
				count++;
			}
			if (rest==0) {
				break;
			}
		}
		if (rest==0) {
			System.out.println("There is a group of integers that sums exactly to "+k+"\n"+"They are: ");
			for (int i=0;i<count;i++) {
				System.out.print(el[i]+" ");
			}
		}
		else {
			System.out.println("There isn't a group of integers that sums exactly to "+k);
		}
		
		
	}
	public static void find(int[]arr,int b) {
		if(rest>=arr[b]) {
			rest=rest-arr[b];
		}
	}
}
