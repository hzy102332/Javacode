package lab2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class l1 {
	public static void main(String[]args) {
		ArrayList<Integer> arry= new ArrayList<>();

		for (int i =0;i<20;i++) {
			arry.add(i,(int)(Math.random()*100));
		}
		for (int a=0;a<20;a++) {
			if (arry.get(a)%2==0) {
				arry.set(a, 0);
			}
		}
		Iterator<Integer> iter = arry.iterator();
		while(iter.hasNext()){
			int n = iter.next();
			if (n!=0) {
			System.out.print(n+" ");
		}}
	}
}
