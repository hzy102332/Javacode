package lab3;

import java.util.LinkedList;
import java.util.Scanner;

public class stacksinglyLinkedlist {
	
	
	public static void main(String []args) {
		Scanner s = new Scanner(System.in);
		LinkedList<Integer> arr = new LinkedList<Integer>();
		arr.isEmpty();
		
		
		int len=3;
		while(len>0) {
		System.out.print("Please enter the number: ");
//		int i =s.nextInt();
		String b = s.next();
		arr.add(Integer.parseInt(b));
		System.out.println("Push element: "+b);
		len--;
		
		}
		if (len==0) {
		System.out.println("Stack is full");
		}
		System.out.println("====================");
		
		while(!arr.isEmpty()) {
			System.out.println("Popped element: "+arr.getLast());
			arr.removeLast();
		}
		
		System.out.println("====================");
		
		
		
		
	}
}
