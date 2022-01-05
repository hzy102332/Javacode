package lab3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PrintReverse {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the arry: ");
		String number= s.nextLine();
		String[] ar=number.split(",");
		int []arr 	= new int [ar.length];;	
		for (int i= 0;i<ar.length;i++){
			arr[i]=(Integer.parseInt(ar[i]));
		}
		int index=arr.length-1;
		recursion(arr,index);
	
		
	}
	public static void recursion(int [] arr,int index) {
		
		System.out.print(arr[index]+" ");
		index--;
		if(index>=0) {
			recursion(arr,index);
		}
		
	}

}
