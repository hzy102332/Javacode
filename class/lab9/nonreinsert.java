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
//				if (x.compareTo(tree.left.key)<0) {// ���xС��t�����������嵽t��������������LL����ת����
//					tree = rr(tree);
//				}else {
//					tree = lrrotation(tree);//��֮���嵽��������������
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
//		//��� t=null �򷵻�-1�� ����t.height 
//		return t == null ? -1 : t.height;
//	}
}
