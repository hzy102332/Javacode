package lab6;

import java.util.Arrays;

public class fraction {
	public static void main(String[]args) {
		
		double [][] r = new double[11][11];
		double [] v = new double [10];
		String [] a = new String [10];
		for (int i=0;i<a.length;i++) {
			Fractions f= new Fractions((int)(Math.random()*10+1),(int)(Math.random()*10+1));
			a[i]=f.toString();
			v[i]=f.getvalue();
		}
		
		System.out.println("The origianl array: "+Arrays.toString(a)+"\n"
		+Arrays.toString(v)+"\n");

		Sort(v,a);
		System.out.print("After sort: "+Arrays.toString(a));
	}
	static void Sort(double []arr,String [] a ) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
//					 swap arr[j+1] and arr[i]
					double temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					
					String t= a[j];
					a[j]=a[j+1];
					a[j+1]=t;
				}
	}
}

