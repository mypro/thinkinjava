package thinkInjava.c8;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myutil.Prt;

class PrintData {
	static void print(Enumeration e) {
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement().toString());
		}
	}
}

public class Enumerators2 {

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
		Vector v = new Vector();
		for (int i = 0; i < 5; i++) {
			v.addElement(new Mouse(i));
		}
		Hashtable h = new Hashtable();
		for (int i = 0; i < 5; i++) {
			h.put(new Integer(i), new Hamster(i));
		}

		System.out.println("Vector");
		PrintData.print(v.elements());
		Prt.outln("Hashtable");
		PrintData.print(h.elements());

	}
}
