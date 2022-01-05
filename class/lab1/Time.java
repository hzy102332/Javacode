package lab1;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.LinkedList;

public class Time {
	public static void main(String[] args) {
		// Through Iterator traversing LinkedList
		iteratorLinkedListThruIterator(getLinkedList());

		// Through random traversing LinkedList
		iteratorLinkedListThruForeach(getLinkedList());

		// Through for loop method 2 traversing LinkedList
		iteratorThroughFor2(getLinkedList());

		// Through PollFirst() traversing LinkedList
		iteratorThroughPollFirst(getLinkedList());

		// Through PollLast() traversing LinkedList
		iteratorThroughPollLast(getLinkedList());

		// Through removeFirst() traversing LinkedList
		iteratorThroughRemoveFirst(getLinkedList());

		// Through removeLast() traversing LinkedList
		iteratorThroughRemoveLast(getLinkedList());
	}

	// Create a list
	private static LinkedList getLinkedList() {
		LinkedList llist = new LinkedList();
		for (int i = 0; i < 100000; i++)
			llist.addLast(i);

		return llist;
	}

	/**
	 * Through Iterator traversing LinkedList
	 */
	private static void iteratorLinkedListThruIterator(LinkedList<Integer> list) {
		if (list == null)
			return;

		// record starting time
		long start = System.currentTimeMillis();

		for(int i=0;i<9;i++) {
			
		}
		for (Iterator iter = list.iterator(); iter.hasNext();)
			iter.next();

		// record end time
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorLinkedListThruIterator£º" + interval + " ms");
	}

	/**
	 * Through random traversing LinkedList
	 */
	private static void iteratorLinkedListThruForeach(LinkedList<Integer> list) {
		if (list == null)
			return;

		// record starting time
		long start = System.currentTimeMillis();

		int size = list.size();
		for (int i = 0; i < size; i++) {
			list.get(i);
		}
		// record end time
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorLinkedListThruForeach£º" + interval + " ms");
	}

	/**
	 * Through for loop method 2 traversing LinkedList
	 */
	private static void iteratorThroughFor2(LinkedList<Integer> list) {
		if (list == null)
			return;

		// record starting time
		long start = System.currentTimeMillis();

		int i=0;
		for (Integer integ : list)
//			list[1]==integ;
			;

		// record end time
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorThroughFor2£º" + interval + " ms");
	}

	/**
	 * Through PollFirst() traversing LinkedList
	 */
	private static void iteratorThroughPollFirst(LinkedList<Integer> list) {
		if (list == null)
			return;

		// record starting time
		long start = System.currentTimeMillis();
		while (list.pollFirst() != null)
			;

		// record end time
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorThroughPollFirst£º" + interval + " ms");
	}

	/**
	 * Through PollLast() traversing LinkedList
	 */
	private static void iteratorThroughPollLast(LinkedList<Integer> list) {
		if (list == null)
			return;

		// record starting time
		long start = System.currentTimeMillis();
		while (list.pollLast() != null)
			;

		// record end time
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorThroughPollLast£º" + interval + " ms");
	}

	/**
	 * Through removeFirst() traversing LinkedList
	 */
	private static void iteratorThroughRemoveFirst(LinkedList<Integer> list) {
		if (list == null)
			return;

		// record starting time
		long start = System.currentTimeMillis();
		try {
			while (list.removeFirst() != null)
				;
		} catch (NoSuchElementException e) {
		}

		// record end time
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorThroughRemoveFirst£º" + interval + " ms");
	}

	/**
	 * Through removeLast() traversing LinkedList
	 */
	private static void iteratorThroughRemoveLast(LinkedList<Integer> list) {
		if (list == null)
			return;

		// record starting time
		long start = System.currentTimeMillis();
		try {
			while (list.removeLast() != null)
				;
		} catch (NoSuchElementException e) {
		}

		// record end time
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorThroughRemoveLast£º" + interval + " ms");
	}

}
