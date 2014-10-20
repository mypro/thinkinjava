package thinkInjava.c11;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myutil.Prt;

public class ShowMethodsClean {
	static final String usage = "usage: \n" + "ShowMethods qualified.class.name\n"
			+ "To show all methods in class or: \n" + "ShowMethods qualified.class.name word\n"
			+ "To search for methods involving 'word'";

	public static void main(String[] args) {

		// String[] args = { "java.lang.String" };
		if (args.length < 1) {
			Prt.outln(usage);
			System.exit(0);
		}

		try {
			Class c = Class.forName(args[0]);
			Method[] m = c.getMethods();
			Constructor[] ctor = c.getConstructors();
			String[] n = new String[m.length + ctor.length];

			for (int i = 0; i < m.length; i++) {
				String s = m[i].toString();
				n[i] = StripQualifiers.strip(s);
			}
			for (int i = 0; i < ctor.length; i++) {
				String s = ctor[i].toString();
				n[i + m.length] = StripQualifiers.strip(s);
			}
			if (args.length == 1) {
				for (String element : n) {

					Prt.outln(element.toString());

				}
			} else {
				for (int i = 0; i < n.length; i++) {
					if (n[i].toString().indexOf(args[i]) != -1) {
						Prt.outln(n[i].toString());
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

		// String[] args = { "java.lang.String" };
		if (args.length < 1) {
			Prt.outln("usage");
			System.exit(0);
		}

		try {
			Class c = Class.forName(args[0]);
			Method[] m = c.getMethods();
			Constructor[] ctor = c.getConstructors();
			String[] n = new String[m.length + ctor.length];

			for (int i = 0; i < m.length; i++) {
				String s = m[i].toString();
				n[i] = StripQualifiers.strip(s);
			}
			for (int i = 0; i < ctor.length; i++) {
				String s = ctor[i].toString();
				n[i + m.length] = StripQualifiers.strip(s);
			}
			if (args.length == 1) {
				for (String element : n) {

					Prt.outln(element.toString());

				}
			} else {
				for (int i = 0; i < n.length; i++) {
					if (n[i].toString().indexOf(args[i]) != -1) {
						Prt.outln(n[i].toString());
					}
				}

			}
		} catch (ClassNotFoundException e) {
			Prt.outln("No such class : " + e);
		}

	}
}

class StripQualifiers {
	private StreamTokenizer st;

	public StripQualifiers(String qualified) {
		st = new StreamTokenizer(new StringReader(qualified));
		st.ordinaryChar(' '); // Keep the spaces
	}

	public String getNext() {
		String s = null;
		try {
			if (st.nextToken() != StreamTokenizer.TT_EOF) {
				switch (st.ttype) {
				case StreamTokenizer.TT_EOL:
					s = null;
					break;
				case StreamTokenizer.TT_NUMBER:
					s = Double.toString(st.nval);
					break;
				case StreamTokenizer.TT_WORD:
					s = new String(st.sval);
					break;
				default: // single character in ttype
					s = String.valueOf((char) st.ttype);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return s;
	}

	public static String strip(String qualified) {
		StripQualifiers sq = new StripQualifiers(qualified);
		String s = "", si;
		while ((si = sq.getNext()) != null) {
			int lastDot = si.lastIndexOf('.');
			if (lastDot != -1) {
				si = si.substring(lastDot + 1);
			}
			s += si;
		}
		return s;
	}
} // /:~
