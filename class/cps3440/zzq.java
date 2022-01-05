package cps3440;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Arrays;
public class zzq {


		// sort the array
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
				}

			}
		}

		private static int[] RadixSort(int[] array) {
			int maxNumber = Get_Max_Number(array);
			for (int exp = 1; maxNumber / exp > 0; exp *= 10) {
				array = Counting_Sort(array, exp);
			}
			return array;
		}

		// find the largest number in the array
		private static int Get_Max_Number(int[] array) {
			int maxNumber = array[0];
			for (int i = 1; i < array.length; ++i) {
				if (array[i] > maxNumber)
					maxNumber = array[i];
			}
			return maxNumber;
		}

		private static int[] Counting_Sort(int[] array, int exp) {
			int[] temp = new int[array.length];// store the number in each digit
			int[] count = new int[10];// store the counting number from 1-9
			int[] array1 = new int[array.length];// store the sorted array
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i] / exp % 10;
			}
			for (int i = 0; i < array.length; i++) {
				count[temp[i]]++;
			}
			int index = 0;
			for (int n = 0; n < 10; n++) {
				// can insert j times for each n
				int j = count[n];
				for (int i = 0; i < array.length && j > 0; i++) {
					if (temp[i] == n) {
						array1[index] = array[i];
						index++;
						j--;
					}
				}
			}
			return array1;
		}

		private static int[] generateArray(int len, int max) {
			int[] arr = new int[len];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int) (Math.random() * max);
			}
			return arr;
		}

		public static void writeArrayToExcel(int[][] data, String string) {
			int rowNum = data.length;
			int columnNum = data[0].length;
			try {
				FileWriter fw = new FileWriter(string);
				for (int i = 0; i < rowNum; i++) {
					for (int j = 0; j < columnNum; j++)
						fw.write(data[i][j] + "\t"); // tab space
					fw.write("\n");
				}
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public static void main(String[] args) {
			int k = 100;
			int maxNum = 50000;
			int step = 100;
			int exStep = 10;
			int[][] time = new int[3][500];

			for (int i = 100; i <= maxNum; i += step) {
				System.out.print("step" + i/100 + ": ");
				long temptime1 = 0;
				long temptime2 = 0;
				for (int j = 0; j < exStep; j++) {
					int arr1[] = generateArray(i, k);
					long time1 = System.currentTimeMillis();
					int[] array1 = HeapSort(arr1);
					long time2 = System.currentTimeMillis();
					long time5 = time2 - time1;
					temptime1 = temptime1 + time5;

					int arr2[] = generateArray(i, k);
					long time3 = System.currentTimeMillis();
					int[] array2 = RadixSort(arr2);
					long time4 = System.currentTimeMillis();
					long time6 = time4 - time3;	
					temptime2 = temptime2 + time6;
				}
				System.out.print("Heap_Sort time is: " + temptime1/10);
				System.out.println(" Radix_Sort time is: " + temptime2/10);
				time[0][i / 100 - 1] = (int) (temptime1 / 10);
				time[1][i / 100 - 1] = (int) (temptime2 / 10);
				time[2][i / 100 -1] = i;
			}
			writeArrayToExcel(time, "C:\\Users\\97432\\Desktop\\sort.xls");
	//testing if the sorting algorithms are correct

			/*
			 * int arr2[] = generateArray(10, 100);
			 * System.out.println(Arrays.toString(arr2)); int[] array2 = HeapSort(arr2);
			 * System.out.print(Arrays.toString(array2));
			 * 
			 * int arr3[] = generateArray(10, 100);
			 * System.out.println(Arrays.toString(arr3)); int[] array3 = RadixSort(arr3);
			 * System.out.print(Arrays.toString(array3));
			 */

		}
}
