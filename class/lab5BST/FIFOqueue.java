package lab5BST;

import java.util.PriorityQueue;
import java.util.Queue;

public class FIFOqueue {
	public static void main(String[]args) {
			Queue<Integer> q = new PriorityQueue<Integer>();
			int key = q.size();
			insert(q,2,key);
			insert(q,5,key);
			insert(q,12,key);
			insert(q,3,key);
			insert(q,10,key);
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
			
	}
	public static void insert(Queue<Integer> a, int n, int key) {
		a.add(n);
		key++;
	}
}
