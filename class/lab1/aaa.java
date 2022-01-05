package lab1;

import java.util.Arrays;

public class aaa {
	public static void main(String[] args) {
		int [] array = {2,3,4,5,6,7};
		int [] Array = Arrays.copyOf(array, array.length+1);
		Array[Array.length-1]=9;
		System.out.print(Array[6]);
		
	}

}
