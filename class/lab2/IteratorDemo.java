package lab2;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Iterator;
	import java.util.LinkedList;
	import java.util.List;

	public class IteratorDemo {
		static List<Integer> array = new ArrayList<Integer>();
		static List<Integer> linked = new LinkedList<Integer>();

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			IteratorDemo terDemo = new IteratorDemo();
			terDemo.traverseElementType1();
			System.out.println("==========================");
			terDemo.traverseElementType2();

			initStaticData();
			System.out.println("==========================");
			System.out.println("Time consumption ArrayList visitor£º" + getTime(array));
			System.out.println("Time consumption LinkedList visitor£º" + getTime(linked));

			System.out.println("==========================");
			System.out.println("Time consumption ArrayList insert£º" + insertTime(array));
			System.out.println("Time consumption LinkedList insert£º" + insertTime(linked));
		}

		void traverseElementType1() {
			ArrayList<String> list = new ArrayList<String>();

			list.add("Apple");

			list.add("Banana");

			list.add("Orange");

			Iterator<String> iter = list.iterator();
			System.out.println("The first way to visit every element by Iterator");

			while (iter.hasNext()) {

				String str = iter.next();

				System.out.println(str);

			}
		}

		void traverseElementType2() {
			LinkedList<String> list = new LinkedList<String>();

			list.add("Apple");

			list.add("Banana");

			list.add("Orange");

			System.out.println("The second way to visit every element by Iterator");

			for (String iter : list) {

				System.out.println(iter);

			}
		}

		public static void initStaticData() {
			for (int i = 0; i < 10000; i++) {
				array.add(i);
				linked.add(i);
			}
		}

		public static long getTime(List list) {
			long time = System.currentTimeMillis();
			for (int i = 0; i < 10000; i++) {
				//Use binary search
				int index = Collections.binarySearch(list, list.get(i));
			}
			return System.currentTimeMillis() - time;
		}

		public static long insertTime(List list) {
			long time = System.currentTimeMillis();
			for (int i = 100; i < 10000; i++) {
				// insert data in index 10
				list.add(10, i);
			}
			return System.currentTimeMillis() - time;
		}
}
