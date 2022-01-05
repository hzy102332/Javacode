package lab9;

//import Lab8AVLtree.AVLNode;

public class nonreinsert<K extends Comparable<K>> {
//	public AVLNode<K> insert(K x, AVLNode<K> tree) {
//		if (tree==null) {
//			tree =  new AVLNode<K>(x);
//			return tree;
//		}
////		left or right
//		int result = x.compareTo(tree.key);
//		if (result < 0 ) {
////			insert left
//			tree.left =insert(x,tree.left);
//			//check balance
//			if (height(tree.left)-height(tree.right)==2) {
//				// need to balance
//				if (x.compareTo(tree.left.key)<0) {// 如果x小于t的左子树，插到t的左子树，符合LL右旋转调整
//					tree = rr(tree);
//				}else {
//					tree = lrrotation(tree);//反之，插到左子树的右子树
//				}
//			}
//		}else if (result>0) {
//			tree.right = insert(x, tree.right);
//			if (height(tree.right)-height(tree.left)==2) {
//				if (x.compareTo(tree.right.key)>0) {
//					tree=lr(tree);
//				}else {
//					tree=rlrotation(tree);
//				}
//			}
//		}else {
//			//have already exist
//		}
//		tree.height = Math.max(height(tree.left),height (tree.right))+1;
//		return tree;
//	}
//	
//	public int height(AVLNode<K> t) {
//		//如果 t=null 则返回-1， 否则t.height 
//		return t == null ? -1 : t.height;
//	}
}
