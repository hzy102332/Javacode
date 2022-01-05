package lab7;

import java.util.ArrayList;
import java.util.Scanner;
 class ds{
	
	int top = -1;
	ArrayList<Integer> array = new ArrayList<Integer>();
	
	int  pop() {
		int e = array.get(top);
		System.out.println("The element "+e+" has been removed");
		return array.get(top--);
	}
	void push(int element) {
		array.add(element);
		top++;
	}
	void print() {
		for (int i =0;i<array.size();i++) {
			System.out.print(array.get(i)+" ");
		}
	}
	int findmin() {
		int min= array.get(0);
		for (int i =0; i<array.size();i++) {
			if (min>array.get(i)) {
				min=array.get(i);
			}
		}
		return min;
	}
}
public class datastructure {
	public static void main(String[] args) {
		ds v = new ds();
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter some number: ");
		String n = s.nextLine();
		String[] arr = n.split("");
		for (int i =0;i<arr.length;i++) {
			v.push(Integer.parseInt(arr[i]));
		}
		
		System.out.print("Enter the 1 to delete the last number: ");
		int a =s.nextInt();
		if (a==1) {
			v.pop();
			v.print();
		}
		else {
			v.print();
		}
		
		System.out.println("\nThe minimun value is:"+v.findmin());
		
	}
	
}
