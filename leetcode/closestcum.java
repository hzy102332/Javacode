package leetcode;

import java.util.Arrays;

public class closestcum {
	public static void main(String[]args) {
		int nums[] = {-100,-98,-2,-1};
		System.out.print(threeSumClosest(nums, -101));
	}
	public static int threeSumClosest(int[] nums, int target) {        
        int len = nums.length;
        Arrays.sort(nums);
        if (len == 3)
            return nums[0]+nums[1]+nums[2];
        
        int cloest = -9999;
        int sum = 0;
        for(int i = 0; i < len-1; i++){        
            int l = i+1;
            int r = len-1;
            while(l < r){    
                sum = nums[i]+nums[l]+nums[r];
                if (sum == target)
                    return target;
                else
                    if (Math.abs(target-cloest) > Math.abs(target-sum))
                        cloest = sum;               
                if (sum < target)
                    l++;
                else
                    r--;
            }
            if (nums[i] > target)
                break;    
        }
        return cloest;
    }
}
