package Lab8AVLtree;

import lab5BST.TreeNode;

public class AVLsingledoublerotation <K extends Comparable, V>{
	  static TreeNode root ; 
	public static void main(String []args) {
		AVLsingledoublerotation<Integer,Integer> tree = new AVLsingledoublerotation();
		tree.put(30, 30);
		tree.put(20,20);
		tree.put(50,50);
		tree.put(10,10);
		tree.put(25,25);
		tree.put(5,5);
		tree.put(23, 23);
		tree.put(27, 27);
		tree.put(26,26);
		tree.put(28, 28);
		tree.preOrder(root);
		tree.todo("right_sr",root,root);
		tree.todo("left_sr",root,root);
		tree.todo("dr_r", root , root);
		System.out.print("\n");
//		tree.todo("dr_l", root, root);
	}
	public void todo(String type,TreeNode node, TreeNode root) {
		switch (type){
		case "right_sr":
			right_sr(node);
			System.out.print("\n"+"After right single rotation: \n");
			preOrder(root);
			return;
		case "left_sr":
			left_sr(node);
			System.out.print("\n"+"After left single rotation: \n");
			preOrder(root);
			return;
		case "dr_r":
			dr_lr(node);
			System.out.print("\n"+"After right double rotation: \n");
			preOrder(root);
			return;
		case "dr_l":
			dl_rl(node);
			System.out.print("\n"+"After left double rotation: \n");
			preOrder(root);
			return;
		default:
			return;
		}
	}
	
	public  void dr_lr(TreeNode node) {
		TreeNode temp = node.right;
		int tempkey = (int) node.value;
		node.value = node.left.right.value;
		node.right = node.left.right;
		node.left.right = node.left.right.left;
		node.right.left = node.right.right;
		node.right.right = temp;
		node.right.value = tempkey;
	}
	public void dl_rl(TreeNode node) {
		TreeNode temp = node.left;
		int tempkey = (int) node.value;
		node.value = node.right.left.value;
		node.left = node.right.left;
		node.right.left = node.right.left.right;
		node.right.right = node.left.left;
		node.left.left = temp;
		node.left.value = tempkey;
	}
	//建立左旋转函数left_rotation
	 public void left_sr(TreeNode node)	{	
		TreeNode temp = node.left;
		int temp_key = (int)node.value;
		node.left  = node.right;
		node.value   = node.right.value;
		node.right = node.left.right;
		node.left.right = node.left.left;
		node.left.left  = temp;
		node.left.value   = temp_key;
	}
	//建立右旋转函数right_rotation
	public void right_sr(TreeNode node){
		if (node == null) {
			return;
		}
		TreeNode temp = node.right;
		int temp_key = (int)node.value;
		node.right  = node.left;
		node.value   = node.left.value;
		node.left = node.right.left;
		node.right.left = node.right.right;
		node.right.right  = temp;
		node.right.value  = temp_key;
	}
	public void put(K key, V value) {
		  if (root == null) {
		   root = new TreeNode<K, V>(key, value);
		   return;
		  }
		  TreeNode x = root;
		  while (x != null) {
			  if (x.key == key) {
				  TreeNode node = getNode(key);
				  node.value = value;
				  return;
			  } 
			  
			 else if (key.compareTo(x.key) < 0) {
			   if (x.left != null) {
				   x = x.left;
			   } 
			   else {
				   TreeNode node = new TreeNode(key, value);
				   node.parent = x;
				   x.left = node;
				   return;
			   }
			 } 
			 else if (key.compareTo(x.key) > 0) {
			   if (x.right != null) {
				   x = x.right;
			   } 
			   else {
				   TreeNode node = new TreeNode(key, value);
				   node.parent = x;
				   x.right = node;
				   return;
			   	}
			 }
		  	}
		 }
	TreeNode<K, V> getNode(K key) {
		  TreeNode<K, V> t = root;
		  while (t != null) {
		   if (t.key == key) {
		    return t;
		   } else if (key.compareTo(t.key) < 0) {
		    t = t.left;
		   } else {
		    t = t.right;
		   }
		  }
		  return null;
		 }
		 public V get(K key) {
		  TreeNode<K, V> node = getNode(key);
		  if (node == null) {
		   return null;
		  } else {
		   return node.value;
		  }
		 }
	 public void preOrder(TreeNode root){ 
	         if (root != null)
	         {
	             System.out.print(root.value + " ");
	             preOrder(root.left);
	             preOrder(root.right);
	         }
	     }	
}

	