package Lab8AVLtree;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class AVLSDrotation {	
	static AVLNode root;
	public static void main (String []args) {
		MyAVLTree<Integer> tree = new MyAVLTree<Integer>();
		
//		System.out.print("Enter the k for 2^k-1 node:");
//		Scanner s = new Scanner (System.in);
//		int n =(int) (Math.pow(2,s.nextInt())-1);
		long start =System.currentTimeMillis();
		try {
		tree.insert(20);
		tree.insert(15);
		tree.insert(50);
		tree.insert(10);
		tree.insert(18);
		tree.insert(5);
		tree.insert(19);
//		tree.insert2(30);
//		tree.insert2(60);
//		tree.insert(70);
////
//		tree.mnodewtwo(19);
		tree.print();
//		System.out.print(tree.height()+"\n");
		
		
//		for (int i = 1;i<=n;i++) {
//			tree.insert(i);
//		}
//		tree.print();
		}
		catch (NoSuchElementException e){
		}
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("The runnig time is£º" +interval+ " ms");
	}
}