package lab3;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class doublelinkedlistbubblesort {
	public static void main(String []args) {
		LinkedList<Integer> lkl = new LinkedList<Integer>();
		for(int i=0;i<10;i++) {
			lkl.add((int)(Math.random()*100+1));
		}
		System.out.println("The original array is: ");
		print(lkl);
		
		
		
		long start =System.currentTimeMillis();	
	 	try {
			sort(lkl);
			System.out.println("=========================="+"\n"+"After sorting, the array is:");
		}
		catch (NoSuchElementException e){
		}
		long end = System.currentTimeMillis();
		long interval = end - start;
		print(lkl);
		System.out.println("=========================="+"\n"+"The runnig time is£º" +interval+ " ms");
		
	}
	public static void print( LinkedList<Integer> arr) {
		int n = arr.size();
		for (int i = 0; i < n; ++i)
		System.out.print(arr.get(i) + " ");
		System.out.println();
	}
	public static void sort(LinkedList<Integer> arr) {
			int n = arr.size();
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n - i - 1; j++) {
					if (arr.get(j) > arr.get(j+1)) {
						int temp = arr.get(j);
						arr.set(j, arr.get(j+1));
						arr.set(j+1, temp);
					}
				}
			}
		}

}
