package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class twonumber {
	public static void main(String []args) {
		int [] nums = {3,2,4};
		int target = 6;
		System.out.print(Arrays.toString(twoSum(nums,target)));
		
	}
	public static int[] twoSum(int [] nums,int target) {
		int [] result = {0,0};
		int a,b,num1,num2;
		boolean f = false;
		for(int i = 0; i < nums.length; i++) {
			a = nums[i];
			num1 = i;
			for(int j =i+1;j<nums.length;j++) {
				b = nums[j];
				num2 = j;
				if (a+b == target) {
					result[0] = num1;
					result[1] = num2;
					f = true;
					break;
				}
				if(f)
					break;
			}
		}
		return result;
	}
}
