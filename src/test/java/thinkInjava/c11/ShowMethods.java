package thinkInjava.c11;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myutil.Prt;

public class ShowMethods {
	static final String usage = "usage: \n" + "ShowMethods qualified.class.name\n"
			+ "To show all methods in class or: \n" + "ShowMethods qualified.class.name word\n"
			+ "To search for methods involving 'word'";

	public static void main(String[] args) {

		// String[] args = { "java.lang.String" };
		if (args.length < 1) {
			Prt.outln("usage");
			System.exit(0);
		}

		try {
			Class c = Class.forName(args[0]);
			Method[] m = c.getMethods();
			Constructor[] ctor = c.getConstructors();
			if (args.length == 1) {
				for (Method element : m) {
					Prt.outln(element.toString());
				}
				for (Constructor element : ctor) {
					Prt.outln(element.toString());

				}
			} else {
				for (int i = 0; i < m.length; i++) {
					if (m[i].toString().indexOf(args[i]) != -1) {
						Prt.outln(m[i].toString());
					}
				}
				for (int i = 0; i < ctor.length; i++) {
					if (ctor[i].toString().indexOf(args[i]) != -1) {
						Prt.outln(ctor[i].toString());
					}

				}
			}
		} catch (ClassNotFoundException e) {
			Prt.outln("No such class : " + e);
		}

	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################");
	}

	@Test
	public void test() {
		String[] args = { "java.lang.String" };
		if (args.length < 1) {
			Prt.outln("usage");
			System.exit(0);
		}

		try {
			Class c = Class.forName(args[0]);
			Method[] m = c.getMethods();
			Constructor[] ctor = c.getConstructors();
			if (args.length == 1) {
				for (Method element : m) {
					Prt.outln(element.toString());
				}
				for (Constructor element : ctor) {
					Prt.outln(element.toString());

				}
			} else {
				for (int i = 0; i < m.length; i++) {
					if (m[i].toString().indexOf(args[i]) != -1) {
						Prt.outln(m[i].toString());
					}
				}
				for (int i = 0; i < ctor.length; i++) {
					if (ctor[i].toString().indexOf(args[i]) != -1) {
						Prt.outln(ctor[i].toString());
					}

				}
			}
		} catch (ClassNotFoundException e) {
			Prt.outln("No such class : " + e);
		}
	}
} // /:~
