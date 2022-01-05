package Class;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
	public static void main(String[]args) {
		ArrayList<String> a1=new ArrayList<>();
		a1.add("Java");
		a1.add("C++");
		a1.add("Perl");
		a1.add("Python");
		System.out.println(a1);
		System.out.println("Element at Index 1: "+a1.get(1));
		System.out.println("Does it contian Java: "+a1.contains("Java"));
		a1.add(2,"Script");
		System.out.println(a1);
		System.out.println("Is ArrayList Empty: "+a1.isEmpty());
		System.out.println("Index of element pesl:"+a1.indexOf("Perl"));
		System.out.println("Size of the ArrayList :"+a1.size());
		System.out.println("List before Sating");
		for (String b:a1) {
			System.out.println(b);
		}
		Collections.sort(a1);
		System.out.println("List After sorting: ");
		for (String b:a1) {
			System.out.println(b);
		}
	}


}
