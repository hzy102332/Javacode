package lab4;

import java.util.ArrayList;
import java.util.List;

public class Quicksort {

	public static void main(String[] args) {
		List<Integer> arr =new ArrayList<Integer>();
		for(int i=0; i<10;i++) {
			arr.add((int)(Math.random()*100));
		}
		System.out.println("The original array is: ");
		for(int i=0;i<10;i++) {
			System.out.print(arr.get(i)+" ");
		}
		sort(arr);
		System.out.println("\n"+"After sorting: ");
		for(int i=0;i<10;i++) {
			System.out.print(arr.get(i)+" ");
		}
	}
	public static void sort( List<Integer> items )
	 {
	 if( items.size( ) > 1 )
	 {
	 List<Integer> smaller = new ArrayList<>();
	List<Integer> same = new ArrayList<>();
	List<Integer> larger = new ArrayList<>();
	
	 Integer chosenItem = items.get( items.size( ) / 2 );
	 for( Integer i : items )
	 {
	 if( i < chosenItem )
	 smaller.add( i );
	 else if( i > chosenItem )
	 larger.add( i );
	 else
	 same.add( i );
	 }
	
	 sort( smaller ); // Recursive call!
//	 sort( larger ); // Recursive call!
	 for (int i=0;i<larger.size();i++) {
		 for(int j=0;j<larger.size()-1;j++) {
				if (larger.get(j)>larger.get(j+1)) {
					int temp=larger.get(j);
					larger.set(j, larger.get(j+1));
					larger.set(j+1, temp);
				}
	 }}

	 items.clear( );
	 items.addAll( smaller );
	 items.addAll( same );
	 items.addAll( larger );
	 }
	 }

}
