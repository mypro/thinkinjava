package thinkInjava.c8;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Vector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AssocArray extends Dictionary {

	private Vector keys = new Vector();
	private Vector values = new Vector();

	@Override
	public int size() {
		return keys.size();
	}

	@Override
	public boolean isEmpty() {
		return keys.isEmpty();
	}

	@Override
	public Object put(Object key, Object value) {
		keys.addElement(key);
		values.addElement(value);
		return key;
	}

	@Override
	public Object get(Object key) {
		int index = keys.indexOf(key);
		if (index == -1) {
			return null;
		}
		return values.elementAt(index);
	}

	@Override
	public Object remove(Object key) {
		int index = keys.indexOf(key);
		if (index == -1) {
			return null;
		}
		keys.removeElementAt(index);
		Object returnval = values.elementAt(index);
		values.removeElementAt(index);
		return returnval;
	}

	@Override
	public Enumeration keys() {
		return keys.elements();
	}

	@Override
	public Enumeration elements() {
		return values.elements();
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##############################################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################################");
	}

	static String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };

	@Test
	public void test() {
		AssocArray aa = new AssocArray();
		for (char c = 'a'; c < 'z'; c++) {
			aa.put(String.valueOf(c), String.valueOf(c).toUpperCase());
		}
		char[] ca = { 'a', 'e', 'i', 'o', 'u' };
		for (int i = 0; i < ca.length; i++) {
			System.out.print(aa.keys.get(i).hashCode() + "===");
			System.out.println("Uppercase: " + aa.get(String.valueOf(ca[i])));
		}

	}
}
