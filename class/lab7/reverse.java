package lab7;


import java.util.Arrays;
import java.util.Stack;

public class reverse {
	public static void main(String []args) {
		int []a = new int [10];
		Stack<Integer> s = new Stack<Integer>();
		
		for (int i =0;i<10;i++) {
			a[i]=((int)(Math.random()*100));
			s.push(a[i]);
		}
		System.out.println("The origianl array: ");
		System.out.println(Arrays.toString(a));
		System.out.println("Inverse: ");
		for (int i=0;i<a.length;i++) {
			System.out.print(s.pop()+", ");
		}
	}
}
