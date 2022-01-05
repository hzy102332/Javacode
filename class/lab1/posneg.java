package lab1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class posneg {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter the length of the array: ");
		int len = s.nextInt();
		int [] pos = new int [len];
		int [] neg = new int [len];
		int [] arr = new int [2*len];
		for (int i = 0; i <len;i++) {
			 int c = 2*i+1;
			pos [i] = c;
			neg[len-i-1]= Math.negateExact(i+1);
		}
		for (int i=0;i<2*len;i++) {
			if(i<len) {
				arr[i]=neg[i];
				
			}
			else {
				arr[i]=pos[i-len];
				
			}
		}
		
		System.out.print("Please enter the number you want to check: ");
		int x = s.nextInt();
		
//		order(x,arr);
		binary(x,arr);
//		indices(x,arr);

	}
	public static void order(int x,int [] arr) {
		long start =System.currentTimeMillis();
		try {	
				System.out.println("---------------check in order--------------");
				boolean t = false;
				for(int i=0; i<arr.length;i++) {
					if (arr[i]==x) {
						t=true;
					}
				}
				
				if(t) {
					System.out.println("This number "+x+" exists in array");
					t=false;
				}
				else {System.out.println("This number "+x+" not exists in array");}
				
				for(int i=0; i<arr.length;i++) {
					if(arr[i] ==Math.negateExact(x)) {
						t=true;
					}
				}
				if(t) {
					System.out.println("This number "+Math.negateExact(x)+" exists in array");
				}
				else {
					System.out.println("This number "+Math.negateExact(x)+" not exists in array");
				}
				
			}
		catch (NoSuchElementException e){
			}
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("The order runnig time is£º" +interval+ " ms");
		
	}
	public static void binary(int x,int [] arr) {
		long start =System.currentTimeMillis();
		try {
			System.out.println("----------------binary search--------------");
			boolean t = false;  
			boolean neg= true;
			boolean pos= true;
			int low = 0;
			int high= arr.length-1;
			
			if(x < arr[low] || x> arr[high] ){  
		        System.out.println("The number "+x+" is not in the array.");
		        pos=false;
		    }
			if(Math.negateExact(x) < arr[low] || Math.negateExact(x)> arr[high] ){  
		        System.out.println("The number "+Math.negateExact(x)+" is not in the array.");         
		        neg = false;
		    }
			if (pos){
			while (low<=high) {
				int middle = low+(x-arr[low])/(arr[high]-arr[low])*(high-low);
				if (x>arr[middle]) {
					low =middle+1;
					}
				else if (x<arr[middle]) {
					high= middle-1;
					}
				else {
					t=true;
					break;
					}
				}
				
				if (t) {
					System.out.println("This number "+x+" exists in arary");
					t= false;
				}
				else {
					System.out.println("This number "+x+" not exists in array");
				}	
			}
			if (neg) {
				low = 0;
				high= arr.length/2;
			while (low<=high) {
				
				int middle = (low+high)/2;
				if (Math.negateExact(x)>arr[middle]) {
					low =middle+1;
					}
				else if (Math.negateExact(x)<arr[middle]) {
					high= middle-1;
					}
				else {
					t=true;
					break;
					}
				}
			if (t) {
				System.out.println("This number "+Math.negateExact(x)+" exists in arary");
			}
			else {
				System.out.println("This number "+Math.negateExact(x)+" not exists in array");
			}
			}
		}
		catch (NoSuchElementException e){
			}
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("The binary search runnig time is£º" +interval+ " ms");
		
	}
	public static void indices(int x,int [] arr) {
		long start =System.currentTimeMillis();
		try {
			System.out.println("---------------indices search--------------");
			int l = 0;
			int h = arr.length-1;
			boolean t =false;
			while(l<h) {
				if(arr[l]+arr[h]>0) {
					h-=1;
				}
				else if (arr[l]+arr[h]<0) {
					l+=1;
				}
				else {
					t=true;
					break;
				}
			}
			if (t) {
				System.out.println("Both "+x+" and "+Math.negateExact(x)+" are in the array");
			}
			else {
				System.out.println("There are no negative number of "+x+" in the array");
			}
			
			}
		catch (NoSuchElementException e){
			}
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("The indices runnig time is£º" +interval+ " ms");
		System.out.println("-------------------------------------------");
	}

}
