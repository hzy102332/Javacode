package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListReverselterator {
	public static void main(String[] args) {

		  ArrayListReverseIterator arr = new ArrayListReverseIterator();
		  arr.show();
		  arr.reverseseltator();
		  
		  
		 }

		}

		class ArrayListReverseIterator {
		 static ArrayList<Integer> list;
		 
		 ArrayListReverseIterator() {
		  list = new ArrayList<>();
		  for(int i = 0; i < 10 ; i++) {
		   list.add((int)(Math.random()*100));
		  }
		 }
		 
		 public static void show() {
		  Iterator<Integer> iter = list.iterator();
		   while(iter.hasNext()) {
		    System.out.print(iter.next() + " ");
		   }
		   System.out.println();
		 }
		 public static void reverseseltator() {
		  
		  Collections.reverse(list);
		  Iterator<Integer> iter = list.iterator();
		  while(iter.hasNext()) {
		   System.out.print(iter.next() + " ");
		  }
		  System.out.println();

		 }

}
