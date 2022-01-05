package lab1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Matrixcheck {
	public static void main(String []args) {
		Scanner s = new Scanner (System.in);
		System.out.print("Please enter the size of the matirx (NxN): ");
		int size= s.nextInt();
		int [] []arry= new int [size][size];
		
		 for (int i =0; i<size;i++) {
			 for (int j = 0;j<size;j++) {
				 arry[i][j]=i*size+j+1;
			}
		 }
		 for(int i=0;i<size;i++){
			 for(int j=0;j<size;j++){
			 System.out.print(arry[i][j]+" ");
			 }
			 System.out.print("\n");
			 }

		 System.out.print("Please enter the number you want to check: ");
		 long start =System.currentTimeMillis();
			try {
		 int key= s.nextInt();
		 int low = 0;
		 int high = size-1;
		 int line = size/2;
		 check(arry,key,low,high,line);		
			}
			catch (NoSuchElementException e){
			}
			long end = System.currentTimeMillis();
			long interval = end - start;
			System.out.println("The runnig time is£º" +interval+ " ms");
			 			 
	}
	public static void check(int [] []arr,int key,int low ,int high,int line) {
		
			 if(key < arr[low][low] || key > arr[high][high] ){  
			        System.out.println("This number is not in the matrix.");               
			    }  
			 boolean ex=false;
		    while(line>=0 && line<=arr[0].length-1){  
		        int middle = (low + high) / 2; 
		       
			if (key>arr[line][middle]) {
				
				low = middle+1;
				if (low>arr[0].length-1) {
					line+=1;
					low = 0;
				}
				}
			else if(key<arr[line][middle]) {
				high = middle-1;
				if (high<0) {
					line=line-1;
					high=arr[0].length-1;
				}
				}
			else if (high<low) {
				break;
				}
			else {
				ex=true;
				break;
				}
		    }
		    if (ex) {
		    	System.out.println("This number is in this matrix.");
		    }
		    else {System.out.println("This number is not in this matrix.");
		    }
		
	}
}
