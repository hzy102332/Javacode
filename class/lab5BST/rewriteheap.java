package lab5BST;

import java.util.Arrays;
import java.util.Scanner;

public class rewriteheap {
	public static void main(String[]args) {
		int [] a = {15,14,13,12,9,11,8,10,3,6,7,4,5,1,2};
		Scanner s = new  Scanner(System.in);
		System.out.println(Arrays.toString(a));
		System.out.print("Please enter the range you want to sort:");
		String num = s.nextLine();
		String[] range = num.split(",");
		int low = (int)(Integer.parseInt(range[0]));
		int high= (int)(Integer.parseInt(range[1]));
		int [] newa = new int [high-low+1];
		int b =0;
		for (int i=0;i<a.length;i++) {
//			newa[i]=a[low-1];
//			low++;
			if(low<=a[i] && a[i]<=high) {
				newa[b]=a[i];
				b++;
			}
		}
		System.out.println(Arrays.toString(newa));
		int [] a1 = new int [newa.length]; 
		int [] a2 = new int [newa.length];
		for(int i=0 ;i<newa.length;i++) {
			a1[i]=newa[i];
			if(i>=1) {
				creat(a1,i);
			}
		}	
//		sort
		for(int i=newa.length-1;i>=0;i--) {
			a2[i]=newa[0];
			newa[0]=0;
			sort(newa);
		}
		
		System.out.println(Arrays.toString(a2));
		
		
	}
	
	public static void sort(int [] a ) {
		int i=0;
		while(i<a.length) {
			int l=i*2+1;
			int r=i*2+2;
			if (l>a.length ||r>a.length) {
				break;
			}
			if(a[l]>a[r]) {
				swap(a,i,l);
				i=2*i+1;
			}
			else if (a[l]<a[r]){
				swap(a,i,r);
				i=i*2+2;
			}
			else {
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
				if (a[r]>a[k]) {
					swap(a,r,k);
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
