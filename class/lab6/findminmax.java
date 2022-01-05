package lab6;

import java.util.Scanner;

import com.sun.javafx.sg.prism.NGShape.Mode;

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

public class findminmax <K extends Comparable, V >{
	static TreeNode root;
	public static void main(String []args) {
		
		findminmax<Integer, Integer> tree = new findminmax();
		tree.put(7, 7);
		tree.put(4, 4);
		tree.put(3, 3);
		tree.put(12, 12);
		tree.put(2, 2);
		tree.put(9, 9);
		tree.put(10, 10);
		tree.put(6, 6);
		midorder(root);
		System.out.print("\n"+"The Minimun is :");
		findMin(root);
		System.out.print("The Maximun is :");
		findMax(root);
		
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter the range you want to print: ");
		int k1 = s.nextInt();
		int k2 = s.nextInt();
		
		System.out.print("The elements are: ");
		print(root, k1, k2);
		
	}
	
	static void findMin(TreeNode node) {
		if (node == null ) {
			 System.out.println("There is no element");
		}
		else {
			if(node.left!=null) {
				findMin(node.left);
			}
			else{
			System.out.println(node.value);
			}
		}
	}
	static void findMax(TreeNode node) {
		if (node == null ) {
			 System.out.println("There is no element");
		}
		else {
			if(node.right!=null) {
				findMax(node.right);
			}
			else{
			System.out.println(node.value);
			}
		}	
		
		
	}
	
	static void print(TreeNode node, int k1,int k2) {
		
		if ((int)node.key >= k1 && (int)node.key <=k2){
			System.out.print(node.value+" ");
		}
		if (node.left !=null) {
			print(node.left, k1, k2);
			}
		if (node.right !=null) {
				print(node.right,k1,k2);
		}
			
	}
	private static void midorder(TreeNode x) {
		if (x == null) {
			return;
		}
		midorder(x.left);
		System.out.print(x.value+" ");
		midorder(x.right);
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
}
