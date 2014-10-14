package thinkInjava.c08;

import java.util.Enumeration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myutil.Prt;

public class StrSortVector {
	private SortVector v = new SortVector(
	// Anonymous inner class:
			new Compare() {
				@Override
				public boolean lessThan(Object l, Object r) {
					return ((String) l).toLowerCase().compareTo(((String) r).toLowerCase()) < 0;
				}

				@Override
				public boolean lessThanOrEqual(Object l, Object r) {
					return ((String) l).toLowerCase().compareTo(((String) r).toLowerCase()) <= 0;
				}
			});
	private boolean sorted = false;

	public void addElement(String s) {
		v.addElement(s);
		sorted = false;
	}

	public String elementAt(int index) {
		if (!sorted) {
			v.sort();
			sorted = true;
		}
		return (String) v.elementAt(index);
	}

	public Enumeration elements() {
		if (!sorted) {
			v.sort();
			sorted = true;
		}
		return v.elements();
	}

	// Test it:
	public static void main(String[] args) {
		StrSortVector sv = new StrSortVector();
		sv.addElement("d");
		sv.addElement("A");
		sv.addElement("C");
		sv.addElement("c");
		sv.addElement("b");
		sv.addElement("B");
		sv.addElement("D");
		sv.addElement("a");
		Enumeration e = sv.elements();
		while (e.hasMoreElements()) {
			Prt.outln(e.nextElement());
		}
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Prt.outln("before test##############################################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Prt.outln("AfterClass test##########################################################");
	}

	@Test
	public void test() {
		StrSortVector sv = new StrSortVector();
		sv.addElement("d");
		sv.addElement("A");
		sv.addElement("C");
		sv.addElement("c");
		sv.addElement("b");
		sv.addElement("B");
		sv.addElement("D");
		sv.addElement("a");
		Enumeration e = sv.elements();
		while (e.hasMoreElements()) {
			Prt.outln(e.nextElement());
		}
	}
} // /:~