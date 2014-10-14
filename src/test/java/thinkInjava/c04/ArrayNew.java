package thinkInjava.c04;

//: ArrayNew.java
//Creating arrays with new.
import java.util.Random;

public class ArrayNew {
	static Random rand = new Random();

	static int pRand(int mod) {
		return Math.abs(rand.nextInt()) % mod + 1;
	}

	public static void main(String[] args) {
		int[] a;
		a = new int[pRand(20)];
		prt("length of a = " + a.length);
		for (int i = 0; i < a.length; i++) {
			prt("a[" + i + "] = " + a[i]);
		}
		Integer[] SS = { new Integer(1), new Integer(2), new Integer(3), };
		Integer[] ss = new Integer[] { new Integer(1), new Integer(2), new Integer(3), };

	}

	// String[] str = new String[20];

	static void prt(String s) {
		System.out.println(s);
	}
} // /:~
