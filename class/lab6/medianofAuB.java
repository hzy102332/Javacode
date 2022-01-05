package lab6;

import java.util.Arrays;

public class medianofAuB {

	public static void main(String[] args) {
		int [] a = new int [10];
		int [] b = new int [10];
		for (int i =0;i<a.length;i++) {
			a[i]=(int)(Math.random()*100);
			b[i]=(int)(Math.random()*100);
		}
		sort(a);
		sort(b);
		System.out.println("A:"+Arrays.toString(a));
		System.out.println("B:"+Arrays.toString(b));
		findmedian(a,b);
		
		
	}
	static void findmedian( int [] a,int []b) {
		int mid =(a.length+b.length)/2;
		int B=0;
		int A=0;
		for (int i= 0;i<mid-1;i++){
			if (a[A]>=b[B]) {
				B++;
				}
			else if(a[A]<b[B]){
					A++;
				}
		}
		if (a[A]>b[B]) {
			System.out.println("The median of A u B is: "+b[B]);
		}
		else if (a[A]<b[B]){ 
			System.out.println("The median of A u B is: "+a[A]);
		}
		
	}
	
	static void sort(int []arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
//					 swap arr[j+1] and arr[i]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

}
