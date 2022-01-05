package lab9;

import lab5BST.TreeNode;
import lab5BST.buildbstree;

public class findkth {
	public static void main(String[]args) {
		buildbstree<Integer, Integer> tree = new buildbstree<Integer, Integer>();
		tree.put(20, 20);
		tree.put(15, 15);
		tree.put(10, 10);
		tree.put(5, 5);
		tree.put(17,17);
		tree.put(18,18);
		tree.put(16,16);
		tree.put(30,30);
		tree.put(25,25);
		tree.put(40,40);
		tree.print(1);
		tree.findkth(4);
		
	}

}
