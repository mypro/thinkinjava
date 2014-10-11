package thinkInjava.c8;

import java.util.Enumeration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myutil.Prt;

public class StringSortTest {

	static class StringCompare implements Compare {
		@Override
		public boolean lessThan(Object l, Object r) {
			return ((String) l).toLowerCase().compareTo(((String) r).toLowerCase()) < 0;
		}

		@Override
		public boolean lessThanOrEqual(Object l, Object r) {
			return ((String) l).toLowerCase().compareTo(((String) r).toLowerCase()) <= 0;
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
		SortVector sv = new SortVector(new StringCompare());

		sv.addElement("d");
		sv.addElement("A");
		sv.addElement("C");
		sv.addElement("c");
		sv.addElement("b");
		sv.addElement("B");
		sv.addElement("D");
		sv.addElement("a");
		sv.sort();
		Enumeration e = sv.elements();
		while (e.hasMoreElements()) {
			Prt.outln(e.nextElement());
		}
	}
}
