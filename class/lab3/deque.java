package lab3;


import java.util.LinkedList;

public class deque {
	int size;
	LinkedList<Integer> arr= new LinkedList<>();
	public static void main(String[] args) {
		deque d = new deque();
		
		
		System.out.println("==================");
		d.push(10);
		d.push(20);
		d.push(30);
		System.out.println("==================");
		d.pop();
		d.pop();
		d.pop();
		System.out.println("==================");
		d.inject(25);
		d.inject(65);
		d.inject(75);
		System.out.println("==================");
		d.eject();
		d.eject();
		d.eject();
		System.out.println("==================");
	}
	public void push(int e) {
		arr.addFirst(e);
		System.out.println("Push element:" + arr.getFirst());
	}
	public void pop() {
		int temp= arr.getFirst();
		arr.removeFirst();
		System.out.println("Pop element: "+temp);
	}
	public void inject(int x) {
		arr.add(x);
		System.out.println("Insert element: "+arr.getLast());
	}
	public void eject() {
		int temp= arr.getLast();
		arr.removeLast();
		System.out.println("Pop element: "+temp);
	}

}
