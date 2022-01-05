package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(0);
		ListNode a = l;
		l = l.next;
		l = new ListNode(2);
//		l = l.next;
//		l = 3;
//		l = l.next;
//		l = 4;
		String s = "()()(()";
//		String a = s;
//		s.replace("(","");
		int [] as = {3,2,1,5};
//		System.out.print(countMaxOrSubsets(as));
		
		String t = "(";
		System.out.print(t.equals(s.charAt(0)+""));
		
		
		
		
	} 
	public static int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int i : nums){
            max = max|i;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            int temp = nums[i];
            if (temp == max)
                    count++;
            for (int j = i+1; j < nums.length; j++){
                temp = temp|nums[j];
                if (temp == max)
                    count++;
            }
        }
        return count;
    }
	 public static boolean areNumbersAscending(String s) {
	        int l = s.length();
	        int temp = 0;
	       
	        List<Integer> list = new ArrayList<>();
	        for (int i = 0; i < l; i ++){
	            if (s.charAt(i)>='0' && s.charAt(i) <= '9'){
	                temp = temp *10 + Character.getNumericValue(s.charAt(i));
	            }else {
	            	if (temp != 0) {
	                list.add(temp);
	                temp = 0;
	            	}
	            }
	        }
	         int former = list.get(0);
	        for (int i = 1; i < list.size(); i++){
	            if (list.get(i) <= former)
	                return false;
	            former = list.get(i);
	            
	        }
	        return true;
	    }
}
