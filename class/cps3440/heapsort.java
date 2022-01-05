package cps3440;

import java.util.Arrays;
import java.util.Scanner;

public class heapsort {
	public static void main(String []args) {
		
		int number;
		long start, end;
		System.out.print("Please enter the number of elements:");
		Scanner s = new Scanner(System.in);
		number = s.nextInt();
		
		start = System.currentTimeMillis();
		
		int [] a = new int [number];
		
		for (int i =0; i<number; i++) {
			a[i] = (int) (Math.random()*101);
		}
		
		System.out.println("The original array: \n"+Arrays.toString(a));
		int [] a1 = new int [a.length]; 
		int [] a2 = new int [a.length];
				
//		creat heap
		for(int i=0 ;i<a.length;i++) {
			a1[i]=a[i];
			if(i>=1) {
				creat(a1,i);
			}
		}	
//		sort
		for(int i=a.length-1;i>=0;i--) {
			a2[i]=a1[0];
			a1[0]=0;
			sort(a1);
		}
		
		end = System.currentTimeMillis();
		
		long interval = end - start;
		
		System.out.println("After sorted: \n"+Arrays.toString(a2)+"\n"+interval);
		
	}
	public static void sort(int [] a ) {
		int i=0;
		while(i<a.length) {
			int l=i*2+1;
			int r=i*2+2;
			if (l>a.length ||r>a.length) {
				break;
			}
			if (r < a.length) {
				if(a[l]>=a[r]) {
					swap(a,i,l);
					i=2*i+1;
				}
				else if (a[l]<a[r]){
					swap(a,i,r);
					i=i*2+2;
				}else {
					break;
				}
			}else if (l < a.length) {
				swap(a,i,l);
				i=2*i+1;
			}else {
				break;
			}
		}
	}
	public static void creat(int [] a,int i) {
		int next =i;
		for(int k=(i-1)/2;k>=0;k=k/2) {
			int l = k*2+1;
			int r = k*2+2;
			if (next%2==0) {
				check(a,k,l,r);
			}else {
				if (a[l]>a[k]) {
					swap(a,l,k);
				}
			}
			next=k;
			if(k==0) {
				break;
			}
		}
		
	} 
	public static void check(int []a,int x, int y,int z) {
		if(a[z]>a[y]) {
			if(a[z]>a[x]) {
			swap(a,x,z);
			}
		}else {
			if(a[y]>a[x]) {
			swap(a,x,y);
		}}
	}
	public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
