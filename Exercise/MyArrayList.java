package Exercise;

import java.util.ArrayList;

public class MyArrayList {
	public static void main(String[]args) {
		ArrayList<String> obj=new ArrayList<String>();
		System.out.println("Initial size of obj: "+obj.size());
		obj.add("ONE");
		obj.add("TWO");
		obj.add("THREE");
		obj.add("FOUR");
		System.out.println("List is: "+obj);
		obj.add(1, "AAA");
		obj.add(3,"BBB");
		System.out.println("Size of obj after additions: "+obj.size());
		System.out.println("Content if obj"+obj);
		obj.remove(2);
		obj.remove(2);
		System.out.println("Size of obj after deletions: "+obj.size());
		System.out.println("Content of obj: "+obj);
	}
}
