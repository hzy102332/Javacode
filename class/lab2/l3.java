package lab2;
import java.util.LinkedList;
import java.util.Scanner;

public class l3 {

	public static void main(String[] args) {
		int [] arr = {90,60,65,71,75}; 
		LinkedList<Integer> lkl = new LinkedList<Integer>();
		for (int i=0;i<arr.length;i++) {
		lkl.add(arr[i]);
		}
		System.out.print("The original Top-ten scores are : "+lkl+"\n");
		System.out.print("please enter the number you want to remove: ");
		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		lkl.remove(n-1);
		
		System.out.print("After editing the Top-ten scores are : "+lkl);
		
		
		
	}

}
