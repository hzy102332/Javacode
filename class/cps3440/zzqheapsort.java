package cps3440;

import java.util.Arrays;
import java.util.Scanner;

public class zzqheapsort {
public static void main(String []args) {
		
		int number;
		long start, end;
		System.out.print("Please enter the number of elements:");
		Scanner s = new Scanner(System.in);
		number = s.nextInt();
		
		
		int [] a = new int [number];
		
		for (int i =0; i<number; i++) {
			a[i] = (int) (Math.random()*101);
		}
		
		start = System.currentTimeMillis();
		System.out.println("The original array: \n"+Arrays.toString(a));
		int [] a2 = HeapSort(a);
		end = System.currentTimeMillis();
		
		long interval = end - start;
		
		System.out.println("After sorted: \n"+Arrays.toString(a2)+"\n"+interval);
		
	}
	private static int[] HeapSort(int[] array) {
		array = Build_Max_Heap(array);
		for (int i = array.length - 1; i > 0; i--) {
			// swap the root and the last leaf
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			Adjust_Heap(array, i - 1);
		}
		return array;
	}

	// build max heap
	private static int[] Build_Max_Heap(int[] array) {
		for (int i = 0; i < array.length; i++) {
			Adjust_Heap(array, i);
		}
		return array;
	}

	// adjust the heap from down to top
	private static void Adjust_Heap(int[] array, int k) {
		for (int i = k; i > 0; i--) {
			if (i % 2 != 0) {
				if (array[i] > array[i / 2]) {
					// swap parent and left child
					int temp1 = array[i];
					array[i] = array[i / 2];
					array[i / 2] = temp1;
				}
			} else {
				if (array[i] > array[i / 2 - 1]) {
					// swap parent and right child
					int temp2 = array[i];
					array[i] = array[i / 2 - 1];
					array[i / 2 - 1] = temp2;
				}
			}}
		}
}
