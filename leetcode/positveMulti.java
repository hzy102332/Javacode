package leetcode;


import java.util.ArrayList;
import java.util.List;


public class positveMulti {
	public static void main(String []args) {
		 TreeNode a = null;
		 a.val = 3;
		 a.left.val = 9;
		 a.right.val = 20;
		 a.right.right.val = 7;
		 a.right.left.val = 15;
		 zigzagLevelOrder(a);
	}
	 public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        List<Integer> temp = new ArrayList<Integer>();
	        // temp.add(root.val);
	        int level = 1;
	        int heigth = deep(root);

	        result.add(0,OU(root,level,temp));
	        
	        result.add(1,JI(root,level,temp));
	     
	        return result;
	    }

	    public static int deep(TreeNode node) {
			int h1, h2;
			if (node == null) {
				return 0;
			} else {
				h1 = deep(node.left);
				h2 = deep(node.right);
				return (h1 < h2) ? h2 + 1 : h1 + 1;
			}
	    }
	    public static List<Integer> OU(TreeNode node, int h, List<Integer> out){
	        List<Integer> r;
	        List<Integer> l;
	        if (node==null){
	            return out;
	        }
	        if (h>0){
	            r = OU(node.left,h-1,out);
	            l = OU(node.right, h-1,out);
	        }else{
	            out.add(node.val);
	            return out;
	        }
	        return out;
	    }
	    public static List<Integer> JI(TreeNode node, int h, List<Integer> out ){
	        List<Integer> r;
	        List<Integer> l;
	        if (node==null){
	            return out;
	        }
	        if (h>0){
	            r = OU(node.right,h-1,out);
	            l = OU(node.left, h-1,out);
	        }else{
	            out.add(node.val);
	            return out;
	        }
	        return out;
	    }
	    public class TreeNode {
	    	      int val;
	    	      TreeNode left;
	    	      TreeNode right;
	    	      TreeNode() {}
	    	      TreeNode(int val) { this.val = val; }
	    	      TreeNode(int val, TreeNode left, TreeNode right) {
	    	          this.val = val;
	    	          this.left = left;
	    	          this.right = right;
	    	      }
	    	  }
}
