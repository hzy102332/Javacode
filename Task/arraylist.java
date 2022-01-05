package Task;

import java.util.ArrayList;
import java.util.Collections;

public class arraylist {
	public static void main(String []args) {
		ArrayList<String> a= new ArrayList<>();
		System.out.println("Is ArrayList Empty at first: "+a.isEmpty());
		a.add("Google");
		a.add("Apple");
		a.add("Microslft");
		a.add("Amazon");
		a.add("Facebook");
		System.out.println("Top 5 Companies of the world: "+a);
		System.out.println("Best Company: "+a.get(1));
		System.out.println("Second Company: "+a.get(2));
		System.out.println("Last Company in the list: "+a.get(4));
		a.set(3, "Walmart");
		Collections.swap(a, 0, 1);
		System.out.println("Modified Top5 Company: "+a);
	}

}
