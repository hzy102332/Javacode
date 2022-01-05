package treeexam;
class TreeNode <K, V>{
	K key;
	V value;
	TreeNode parent;
	TreeNode left;
	TreeNode right;
	
	public TreeNode (K key, V value) {
		this.key=key;
		this.value=value;
	}
}
public class binarysearchtree <K extends Comparable, V >{
	static TreeNode root;
	public static void main(String []args) {
		binarysearchtree<Integer, Integer> tree = new binarysearchtree();
		int [] a= new int [10];
		for (int i =1;i<=10 ;i++) {
				tree.put(i, i);
			}
		
//		ÖÐ×óÓÒ	
		
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
		 // get node 
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
	
}