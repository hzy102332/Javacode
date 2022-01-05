package cps2232;

public class TestPassArry {
	public static void main(String[]args) {
		int [] a= {1,2};
		System.out.println("Before invoking swap");
		System.out.println("arry is {"+a[0]+","+a[1]+"}");
		swap(a[0],a[1]);
		System.out.println("After invoking swap");
		System.out.println("arry is {"+a[0]+","+a[1]+"}");
		
		System.out.println("Before invoking swapFirstTwoArry ");
		System.out.println("arry is {"+a[0]+","+a[1]+"}");
		swapFirstTwoArry(a);
		System.out.println("After invoking swapFirstTwoArry");
		System.out.println("arry is {"+a[0]+","+a[1]+"}");
		
	}
	public static void swap (int n1 ,int n2) {
		int temp = n1;
		n1 = n2;
		n2 = temp;
	}
	public static void swapFirstTwoArry(int [] arry) {
		int temp = arry[0];
		arry [0] = arry[1];
		arry [1] = temp;
	}
}
