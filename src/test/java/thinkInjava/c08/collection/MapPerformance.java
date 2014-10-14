package thinkInjava.c08.collection;

//: MapPerformance.java
//Demonstrates performance differences in Maps
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapPerformance {
	private static final int REPS = 200;

	public static Map fill(Map m, int size) {
		for (int i = 0; i < size; i++) {
			String x = Integer.toString(i);
			m.put(x, x);
		}
		return m;
	}

	private abstract static class Tester {
		String name;

		Tester(String name) {
			this.name = name;
		}

		abstract void test(Map m, int size);
	}

	private static Tester[] tests = { new Tester("put") {
		@Override
		void test(Map m, int size) {
			for (int i = 0; i < REPS; i++) {
				m.clear();
				fill(m, size);
			}
		}
	}, new Tester("get") {
		@Override
		void test(Map m, int size) {
			for (int i = 0; i < REPS; i++) {
				for (int j = 0; j < size; j++) {
					m.get(Integer.toString(j));
				}
			}
		}
	}, new Tester("iteration") {
		@Override
		void test(Map m, int size) {
			for (int i = 0; i < REPS * 10; i++) {
				Iterator it = m.entrySet().iterator();
				while (it.hasNext()) {
					it.next();
				}
			}
		}
	}, };

	public static void test(Map m, int size) {
		// A trick to print out the class name:
		System.out.println("Testing " + m.getClass().getName() + " size " + size);
		fill(m, size);
		for (Tester test : tests) {
			System.out.print(test.name);
			long t1 = System.currentTimeMillis();
			test.test(m, size);
			long t2 = System.currentTimeMillis();
			System.out.println(": " + (double) (t2 - t1) / (double) size);
		}
	}

	public static void main(String[] args) {
		// Small:
		test(new Hashtable(), 10);
		test(new HashMap(), 10);
		test(new TreeMap(), 10);
		// Medium:
		test(new Hashtable(), 100);
		test(new HashMap(), 100);
		test(new TreeMap(), 100);
		// Large:
		test(new HashMap(), 1000);
		test(new Hashtable(), 1000);
		test(new TreeMap(), 1000);
	}
} // /:~
