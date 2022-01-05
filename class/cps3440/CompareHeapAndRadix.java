package cps3440;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CompareHeapAndRadix {
	
	
	
	public static void main (String []args) {
		int nbrep = 10;
		int k = 100;
		int startnb = 1000;
		int maxnb = 500000;
		int step = 1000;
		long start = 0;
		long end = 0;
		
		int result [] [] = new int [maxnb+1] [3];
		
		for (int i = startnb; i <= maxnb; i += step) {
			long theap = 0;
			long tradix = 0;
			for (int j = 0; j < nbrep; j++) {
				int arr [] = new int [i];
//				generate random array in range (0,k)
				for (int x = 0; x < i; x++) {
					arr[x] = (int) (Math.random()*(k));
				}
				start = System.currentTimeMillis();
//				HeapSort(arr);
				heapsort(arr);
				end = System.currentTimeMillis();
				theap += end - start;
				
				int len = 0; //the max length of the element
				for (int y = k; y > 0; y = y/10) {
					len ++;
				}
				start = System.currentTimeMillis();
				radixsort(arr,len);
				end = System.currentTimeMillis();
				tradix += end - start;
				
//				System.out.print( theap +" " +tradix +" ");
			}
//			System.out.println();
			result [i] [0] = i;
			result [i] [1] = (int) (theap / nbrep);
			result [i] [2] = (int) (tradix / nbrep);
			System.out.println("step" + i/step + ": " +"Heapsort_time: "+result [i] [1] + " Radixsort_time: "+result [i] [2]);
		}
//		System.out.println(Arrays.toString(result));
		writeArrayToExcel(result, "G:\\heapradixsort.xls", startnb, step);
	}
	
	public static void heapsort(int [] a) {
		
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
//			i++;
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
	
	
	public static void radixsort(int [] a,int length) {
		
		int max;
		if (a.length < 10) {
			max =10;
		}else {
			max = a.length;
		}
		int [] count = new int [10];
		int [] bucket = new int [a.length];
		
		for (int k = 1 ;k < length; k++ ) {
			
			for (int i = 0; i < 10; i++) {
				count[i] = 0;
			}
			for (int i = 0; i < a.length; i++) {
				count[getnumber(a[i],k)]++;
			}
			for (int i = 1; i < 10; i++) {
				count[i] = count[i] + count[i-1];	
			}
			for (int i = a.length-1; i >= 0; i--) {
				int j = getnumber(a[i], k);
				bucket[count[j]-1] = a[i];
				count[j]--;
			}
			for (int i = 0; i < a.length; i++) {
				a[i] = bucket[i];
			}
		}
	}
	public static int getnumber (int a, int b) {
		int [] position = {1,10,100,1000};
		int c = (a%position[b] - a%position[b-1])/position[b-1];
		return c;
	}

	public static void writeArrayToExcel(int[][] data, String string, int startnb,int step) {
		int rowNum = data.length;
		int columnNum = data[0].length;
	
		try {
			FileWriter fw = new FileWriter(string);
			fw.write("number"+"\t");
			fw.write("Heapsort_time"+"\t");
			fw.write("Radixsort_time"+"\n");
			
			for (int i = startnb; i < rowNum; i+=step) {
				for (int j = 0; j < columnNum; j++)
					fw.write(data[i][j] + "\t"); // tab space
				fw.write("\n");		
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
