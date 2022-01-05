package lab2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class l2 {
	public static void main(String[]args) {
		LinkedList<Integer>  lkl = new LinkedList<Integer>();
		Scanner s= new Scanner(System.in);
		
		for (int i =0;i<10;i++) {
			lkl.add(i,(int)(Math.random()*100));
		}
		System.out.print("The original array is : "+"\n");
		for(int i=0 ;i<lkl.size();i++){
		System.out.print(lkl.get(i)+" ");
		if (i==lkl.size()-1) {
			System.out.print("\n");
		}
		}
		for (int a=0;a<10;a++) {
			lkl.set(a,0);
			}
		
		System.out.print("Please enter three number: ");
		lkl.add(s.nextInt());
		lkl.add(s.nextInt());
		lkl.add(s.nextInt());
		
		Iterator<Integer> iter = lkl.iterator();
		while (iter.hasNext()) {
			int n = iter.next();
			if (n!=0) {
			System.out.print(n+" ");
		}}
		
		
	}
}
