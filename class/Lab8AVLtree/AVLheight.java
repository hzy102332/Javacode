package Lab8AVLtree;

public class AVLheight {
	public static void h(int h) {
		MyAVLTree<Integer> tree = new MyAVLTree<Integer>();
		int i=0;
		while(true) {
			i++;
			tree.insert(i);
			if (tree.height()==h) {
				break;
			}
		}
		tree.print();
	}
	public static void main (String[]args) {
		MyAVLTree<Integer> tree = new MyAVLTree<Integer>();
		h(4);
	}
	
}
