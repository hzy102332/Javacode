package lab4;

import java.util.Arrays;
import java.util.Scanner;

public class l6 {
		static int count =0;
	public static void main(String []args) {
		
		int [] min=new int [1];
		int [] max=new int [1];
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter the power of 2: ");
		int power=s.nextInt();
		int [] a = new int[(int) Math.pow(2, power)];
		
		for(int i=0 ; i<(int) Math.pow(2, power);i++) {
			a[i]=(int)(Math.random()*100);
		}
		System.out.println("The array is: "+Arrays.toString(a));
		
		Maxmin(a,0,a.length-1,max,min);
		
        System.out.println("the maximiun is: "+max[0]);
        System.out.print("the maximiun is: "+min[0]+"\n"+"the number of compairsons is: "+count);
		
        System.out.println("\n"+"======================================"+"\n"+"The maximum and minimum of 3*2^k: ");
		int [] b = new int[3*(int)Math.pow(2, power)]; 
		for(int i=0 ; i<3*(int) Math.pow(2, power);i++) {
			b[i]=(int)(Math.random()*100);
		}
		System.out.println("The array is: "+Arrays.toString(b));
		count=0;
		
		Maxmin(b,0,b.length-1,max,min);
		System.out.println("the maximiun is: "+max[0]);
	    System.out.print("the maximiun is: "+min[0]+"\n"+"the number of compairsons is: "+count);
		
		
		
	}
	 public static void Maxmin(int[] a, int l, int r,int []max,int[] min) {
		         
		         if (l == r) {
		        	 max[0]=a[l];
		        	 min[0]=a[r];
		             count++;
		         } else if (l == (r - 1)) {
		        	 if (a[l]>a[r]) {
		             max[0] = a[l];
		             min[0] = a[r];
		             count++;
		        	 }else {
		        		 max[0] = a[r];
			             min[0]= a[l];
			             count++;
		        	 }
		         } else {
		        	 int lmax[] = {0};
		        	 int lmin[] = {0};
		        	 int rmax[] = {0};
		        	 int rmin[] = {0};
		        	 int mid =0;
		        	 if(a.length%2==0&& a.length%4!=0) {
		        		mid = a.length/2;
		        		 Maxmin(a, l,mid-1,lmax,lmin);
			             Maxmin(a,mid+1,r,rmax,rmin);
		        	 }
		        	 else {
		        		 mid=(l + r) / 2;
		        		 Maxmin(a, l,mid,lmax,lmin);
		        		 Maxmin(a,mid+1,r,rmax,rmin);
		        	 }
		             if (lmax[0]>rmax[0]) {
		            	 max[0]=lmax[0];
			             count++;
		             }else {
		            	 max[0]=rmax[0];
			             count++;
		             }
		             if (lmin[0]<rmin[0]) {
			             count++;
		            	 min[0]=lmin[0];
		             }else {
		            	 min[0]=rmin[0];
			             count++;
		             }
		         }

		     }

}
