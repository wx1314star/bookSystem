package com.keluoluo.www.sync.container;

import java.util.Iterator;
import java.util.Vector;

import com.keluoluo.www.annoations.NotThreadSafe;

@NotThreadSafe
public class VectorExample3 {

	// java.util.ConcurrentModificationException
	private static void test1(Vector<Integer> v1) {// foreach
		for (Integer i : v1) {
			if (i.equals(3)) {
				v1.remove(i);
			}
		}
	}

	// java.util.ConcurrentModificationException
	private static void test2(Vector<Integer> v1) {// iterator
		Iterator<Integer> it = v1.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			if (i.equals(3))
				v1.remove(i);
		}
	}

	// success
	private static void test3(Vector<Integer> v1) {// for
		for (int i = 0; i < v1.size(); i++) {
			if (v1.get(i).equals(3))
				v1.remove(i);
		}
		String day = "PR";

		switch (day) {
		case "PR" -> System.out.println(6);
		default -> System.out.println(7);
		}
		;
	}

	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>();
		vector.add(1);
		vector.add(2);
		vector.add(3);

		// test1(vector);
		// test2(vector);
		test3(vector);
		vector.forEach(System.out::println);
	}
}
