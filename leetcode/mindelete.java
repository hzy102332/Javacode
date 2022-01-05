package leetcode;

import java.util.ArrayList;

public class mindelete {

	public static void main(String []args) {
		String s = "aababbaabababbbabbbaaaabaabbbabbbbaaab";
		int [] cost = {18,5,12,7,36,33,38,18,40,2,32,14,12,15,35,33,5,28,29,6,40,28,24,28,32,27,20,11,7,34,15,21,13,26,28,39,13,16};
		System.out.print(minCost(s, cost));
	}
	 public static int minCost(String s, int[] cost) {
	        int sum = 0;
	        int temp = 0;
	        for(int i = 0; i<s.length()-1;i++){
	            while(i <s.length()-1 && s.charAt(i) == s.charAt(i+1)){
	                temp = Math.max(cost[i],temp);
	                temp = Math.max(cost[i+1],temp);
	                sum = sum + cost[i];
	                System.out.print(i+1+"+");
	                i++;
	            }
	            if (i>1 && s.charAt(i) == s.charAt(i-1)){
	            	System.out.print(i+1+"+");
	                sum = sum + cost[i] - temp;
	                temp = 0;
	            }
	        }
	        return sum;
//	        List<List<String>> listTest = new ArrayList<List<String>>();
	    }
}
