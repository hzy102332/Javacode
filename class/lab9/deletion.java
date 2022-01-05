package lab9;
import Lab8AVLtree.MyAVLTree;
class AVLNode<K>{
	K element;
	AVLNode<K> left;	
	AVLNode<K> right;
	int height;
	
	public AVLNode(K key) {
		this(key ,null, null);
	}
	public AVLNode(K element, AVLNode<K> LEFT, AVLNode<K> right) {
		this.element=element;
		this.left = left;
		this.right  = right;
	}
}

public class deletion<K extends Comparable<K>> {
	public static void main(String []args) {
		MyAVLTree<Integer> tree = new MyAVLTree<Integer>();
		
 	}
	private AVLNode<K> remove( K x, AVLNode<K> t){
		if( t == null )
			 return t; // Item not found; do nothing
			 int compareResult = x.compareTo(t.element);
			 if( compareResult < 0 )
			 t.left = remove( x, t.left );
		else if( compareResult > 0 )
			 t.right = remove( x, t.right );
		else if( t.left != null && t.right != null ) // Two children
			{
			AVLNode<K> min = t.right;
			while (min.left != null) {
	                min = min.left;
	            }
			 t.element = min.element;
			 
			 t.right = remove( t.element, t.right );
			 }
		else
			 t = ( t.left != null ) ? t.left : t.right;
		return balance( t );
	 }
	private AVLNode<K> balance( AVLNode<K> t ) {
	 if( t == null )
	 return t;
	
		 if( height( t.left ) - height( t.right ) > 1 )
		 if( height( t.left.left ) > height( t.left.right ) )
		 t = rr( t );
		 else
		 t = lrrotation( t );
		 else
		 if( height( t.right ) - height( t.left ) > 1 )
		 if( height( t.right.right ) > height( t.right.left ) )
		 t = lr( t );
		 else
		 t = rlrotation( t );
		
		 t.height = Math.max( height( t.left ), height( t.right ) ) + 1;
		 return t;
	 }
	public int height(AVLNode<K> t) {
		//如果 t=null 则返回-1， 否则t.height 
		return t == null ? -1 : t.height;
	}
	public AVLNode<K> rr (AVLNode<K> tree) {
		AVLNode newt = tree.left;
		tree.left = newt.right;
		newt.right = tree;
		tree.height = Math.max(height(tree.left), height(tree.right))+1;
		newt.height = Math.max(height(newt.left), height(newt.right))+1;
		return newt;
	}
	public AVLNode<K> lr (AVLNode<K> tree){
		AVLNode newt = tree.right;
		tree.right = newt.left;
		newt.left = tree;
		tree.height = Math.max(height(tree.left), height(tree.right))+1;
		newt.height = Math.max(height(newt.left), height(newt.right))+1;
		return newt;
	}
	
	public AVLNode<K> lrrotation (AVLNode<K> tree){
		tree.left = lr(tree.left);
		return rr(tree);
	}
	public AVLNode<K> rlrotation (AVLNode<K> tree){
		tree.right = rr(tree);
		return lr(tree);
	}
	
}
