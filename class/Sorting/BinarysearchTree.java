package Sorting;

public class BinarysearchTree<K extends Comparable,V> {
		TreeNode root;
		
	public static void main(String[] args) {
	
		BinarysearchTree<Integer, String> tree;
		// before
		tree = new BinarysearchTree();
		tree.put(7, "A");
		tree.put(4, "B");
		tree.put(10, "C");
		tree.put(2, "D");
		tree.put(5, "E");
		tree.put(8, "F");
		tree.put(11, "G");
		tree.put(1, "H");
		tree.put(3, "I");
		tree.put(6, "J");
		tree.put(9, "K");

		// remove test
		System.out.println("Before Remove node: I(Index 3)");
		tree.print(2);
		tree.remove(3);
		System.out.println("After Remove node: I(Index 3)");
		tree.print(2);
		System.out.println("========================");
		// print test
		System.out.println("Traversing binary tree");
		tree.print(1);
		tree.print(2);
		tree.print(3);

		// get node
		System.out.println("========================");
		System.out.println("Print Tree Node (Index 4: )"+tree.get(4));

	}

	/**
	 * Insert Function
	 * 
	 * @param key
	 * @param value
	 */
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
			} else if (key.compareTo(x.key) < 0) {
				if (x.left != null) {
					x = x.left;
				} else {
					TreeNode node = new TreeNode(key, value);
					node.parent = x;
					x.left = node;
					return;
				}
			} else if (key.compareTo(x.key) > 0) {
				if (x.right != null) {
					x = x.right;
				} else {
					TreeNode node = new TreeNode(key, value);
					node.parent = x;
					x.right = node;
					return;
				}
			}
		}
	}

	/**
	 * delete node function
	 * 
	 * @param key
	 * @return
	 */
	public void remove(K key) {
		TreeNode<K, V> node = getNode(key);
		if (node == null) {
			return;
		}
		TreeNode<K, V> replication;
		if (node.left != null && node.right != null) {
			replication = node.right;
			while (replication.left != null) {
				replication = replication.left;
			}
			node.key = replication.key;
			node.value = replication.value;
			node = replication;
		}

		if (node.parent.left == node) {
			if (node.left != null) {
				node.left.parent = node.parent;
				node.parent.left = node.left;
			} else if (node.right != null) {
				node.right.parent = node.parent;
				node.parent.left = node.right;
			} else {
				node.parent.left = null;
			}
		} else {
			if (node.left != null) {
				node.left.parent = node.parent;
				node.parent.right = node.left;
			} else if (node.right != null) {
				node.right.parent = node.parent;
				node.parent.right = node.right;
			} else {
				node.parent.right = null;
			}
		}
		node.left = node.right = node.parent = null;
	}

	/**
	 * Through key get TreeNode
	 * 
	 * @param key
	 * @return
	 */
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

	/**
	 * Through key get value
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		TreeNode<K, V> node = getNode(key);
		if (node == null) {
			return null;
		} else {
			return node.value;
		}
	}

	/**
	 * print tree
	 * 
	 * @param type 1£ºPreorder Traversal BinaryTree 2£ºinorder traversal BinaryTree
	 *             3£ºpostorder traversal BinaryTree
	 */
	public void print(int type) {
		switch (type) {
		case 1:
			System.out.print("Preorder Traversal : ");
			beforePrK(root);
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

	/**
	 * Preorder Traversal
	 * 
	 * @param x
	 */
	private void beforePrK(TreeNode x) {
		if (x == null) {
			return;
		}
		System.out.print(x.value+" ");
		beforePrK(x.left);
		beforePrK(x.right);
	}

	/**
	 * inorder traversal
	 * 
	 * @param x
	 */
	private void midPrK(TreeNode x) {
		if (x == null) {
			return;
		}
		midPrK(x.left);
		System.out.print(x.value+" ");
		midPrK(x.right);
	}

	/**
	 * postorder traversal
	 * 
	 * @param x
	 */
	private void afterPrK(TreeNode x) {
		if (x == null) {
			return;
		}
		afterPrK(x.left);
		afterPrK(x.right);
		System.out.print(x.value+" ");
	}

	class TreeNode<K, V> {
		K key;
		V value;
		TreeNode parent;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

}