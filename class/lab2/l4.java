package lab2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class l4 {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int [] arr = {90,60,65,71,75}; 
	String [] name = {"A","B","C","D","E"};
	LinkedList<Integer> lkl = new LinkedList<Integer>();
	LinkedList<String> lkl2 = new LinkedList<String>();
	for (int i=0;i<arr.length;i++) {
		lkl.add(arr[i]);
	}
	for (int i=0; i<name.length;i++) {
		lkl2.add(name[i]);
	}
	System.out.println("The array before sorting:  ");
	for(int i=0;i<lkl.size();i++) {
		System.out.println(lkl2.get(i)+": "+lkl.get(i));
	}
	System.out.print("Please enter the sequence number of the player you want to remove: ");
	int n= s.nextInt();
	lkl.set(n-1, 0);
	lkl2.set(n-1, "");
	for(int i= 0; i<lkl.size();i++) {
		for (int j =lkl.size()-1;j>1;j--) {
			if (lkl.get(j)>lkl.get(j-1)) {
				int t= lkl.get(j);
				lkl.set(j, lkl.get(j-1));
				lkl.set(j-1, t);
				String t2= lkl2.get(j);
				lkl2.set(j, lkl2.get(j-1));
				lkl2.set(j-1, t2);
			}
		}
	}
	
	System.out.println("The array after sorting and remove:  ");
	
	Iterator<Integer> iter =lkl.iterator(); 
	Iterator<String> iter2 =lkl2.iterator(); 
	while(iter.hasNext()) {
		int a =iter.next();
		String b= iter2.next();
		if (a!=0) {
			System.out.println(b+": "+a);
		}
		
	}
	}
}
