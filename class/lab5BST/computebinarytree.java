package lab5BST;

import java.util.Arrays;
import java.util.Scanner;

public class computebinarytree {
	public static void main(String[]args) {
		int count=0;
		int sum=0;
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter the array length: ");
		int l= s.nextInt();
		int [] a = new int [l];
		for(int i=0;i<l;i++) {
			a[i]=(int)(Math.random()*100);
		}
		int deep = (int)(Math.log10(l)/Math.log10(2)); 
		
		int leaves = 0;
		for(int i=0; i<a.length;i++) {
			if (i*2+1>l-1) {
				leaves++;
			}
		}
		
		int nodes =l;
		for(int i=0;i<l;i++) {
			sum+=a[i];
			if(a[i]%2==0) {
				count++;
			}
		}
		System.out.println("The array is: "+Arrays.toString(a));
		System.out.println("The number of leaves is: "+leaves);
		System.out.println("The number of full nodes is: "+nodes);
		System.out.println("The number of even data nodes is: "+count);
		System.out.print("The sum of all the nodes in the tree is: "+sum);
		
		
		
	}
}
