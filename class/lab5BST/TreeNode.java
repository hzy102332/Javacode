package lab5BST;

public class TreeNode <K, V>{
	public K key;
	public V value;
	public TreeNode parent;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode (K key, V value) {
		this.key=key;
		this.value=value;
	}
}