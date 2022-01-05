package lab5BST;

public class buildbstree <K extends Comparable, V >{
	TreeNode root;
	static int count=0;
	public static void main(String []args) {
		buildbstree<Integer, Integer> tree = new buildbstree();
//		int [] a= new int [10];
//		for (int i =1;i<=10 ;i++) {
//				int n= (int)(Math.random()*10);
//				System.out .println(n);
//				tree.put(n, n);
//			}
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
		
//		ÖÐ×óÓÒ	
		tree.print(2);
	}
	
	public void print(int type) {
		switch (type) {
		case 1:
			System.out.print("Preorder Traversal : ");
			preOrder(root);
			System.out.println();
			return;
		case 2:
			System.out.print("inorder traversal : ");
			midPrK(root);
			System.out.println();
			return;
		case 3:
			System.out.print("BinaryTree : ");
			afterPrK(root);
			System.out.println();
			return;
		default:
			System.out.println();
			return;
		}
	}
	public  void findkth(int k) {
		
		count=k;
		search(root);
	}
	private void search(TreeNode root) {
		if (root == null) {
			return;
		}
		search(root.left);
		count--;
		 if (count==0) {
			System.out.print(root.key);
			System.exit(0);
		}
		search(root.right);
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
		 
		  public void preOrder(TreeNode root){ 
		         if (root != null)
		         {
		             System.out.print(root.value + " ");
		             preOrder(root.left);
		             preOrder(root.right);
		         }
		     }	
		  private void midPrK(TreeNode x) {
				if (x == null) {
					return;
				}
				midPrK(x.left);
				System.out.print(x.value+" ");
				midPrK(x.right);
			}
		  private void afterPrK(TreeNode x) {
				if (x == null) {
					return;
				}
				afterPrK(x.left);
				afterPrK(x.right);
				System.out.print(x.value+" ");
			}
}
 

