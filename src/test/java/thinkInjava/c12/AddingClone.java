//: Alias1.java
package thinkInjava.c12;

import java.util.Enumeration;
import java.util.Vector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

class Int2 implements Cloneable {
	private int i;

	public Int2(int ii) {
		i = ii;
	}

	public void increment() {
		i++;
	}

	@Override
	public String toString() {
		return Integer.toString(i);
	}

	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Int2 can't clone");
		}
		return o;
	}

}

class Int3 extends Int2 {
	private int j;

	public Int3(int i) {
		super(i);
	}
}

public class AddingClone {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################");
	}

	@Test
	public void testName() throws Exception {
		Int2 x = new Int2(10);
		Int2 x2 = (Int2) x.clone();
		x2.increment();
		System.out.println("x = " + x + ", x2 = " + x2);

		Int3 x3 = new Int3(7);
		x3 = (Int3) x3.clone();
		Vector v = new Vector();
		for (int i = 0; i < 10; i++) {
			v.addElement(new Int2(i));
		}
		System.out.println("v:" + v);
		Vector v2 = (Vector) v.clone();
		System.out.println("v2:" + v2);
		for (int i = 0; i < v.size(); i++) {
			v2.setElementAt(((Int2) v2.elementAt(i)).clone(), i);
		}
		for (Enumeration e = v2.elements(); e.hasMoreElements();) {
			((Int2) e.nextElement()).increment();

		}
		System.out.println("v : " + v);
		System.out.println("v2: " + v2);

	}
} // /:~
