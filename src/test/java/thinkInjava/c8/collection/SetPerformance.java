package thinkInjava.c8.collection;

//: SetPerformance.java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetPerformance {
	private static final int REPS = 200;

	private abstract static class Tester {
		String name;

		Tester(String name) {
			this.name = name;
		}

		abstract void test(Set s, int size);
	}

	private static Tester[] tests = { new Tester("add") {
		@Override
		void test(Set s, int size) {
			for (int i = 0; i < REPS; i++) {
				s.clear();
				Collection1.fill(s, size);
			}
		}
	}, new Tester("contains") {
		@Override
		void test(Set s, int size) {
			for (int i = 0; i < REPS; i++) {
				for (int j = 0; j < size; j++) {
					s.contains(Integer.toString(j));
				}
			}
		}
	}, new Tester("iteration") {
		@Override
		void test(Set s, int size) {
			for (int i = 0; i < REPS * 10; i++) {
				Iterator it = s.iterator();
				while (it.hasNext()) {
					it.next();
				}
			}
		}
	}, };

	public static void test(Set s, int size) {
		// A trick to print out the class name:
		System.out.println("Testing " + s.getClass().getName() + " size " + size);
		Collection1.fill(s, size);
		for (Tester test : tests) {
			System.out.print(test.name);
			long t1 = System.currentTimeMillis();
			test.test(s, size);
			long t2 = System.currentTimeMillis();
			System.out.println(": " + (double) (t2 - t1) / (double) size);
		}
	}

	public static void main(String[] args) {
		// Small:
		test(new TreeSet(), 10);
		test(new HashSet(), 10);
		// Medium:
		test(new TreeSet(), 100);
		test(new HashSet(), 100);
		// Large:
		test(new HashSet(), 10000);
		test(new TreeSet(), 10000);
	}
} // /:~
