//: Alias1.java
package thinkInjava.c12;

import com.myutil.Prt;

public class Snake implements Cloneable {

	private Snake next;
	private char c;

	Snake(int i, char x) {
		c = x;
		if (--i > 0) {
			next = new Snake(i, (char) (x + 1));
		}
	}

	void increment() {
		c++;
		if (next != null) {
			next.increment();
		}
	}

	@Override
	public String toString() {
		String s = ": " + c;
		if (next != null) {
			s += next.toString();
		}
		return s;
	}

	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
		}
		return o;
	}

	public static void main(String[] args) {
		Snake s = new Snake(5, 'a');
		Prt.outln("s=" + s);
		Snake s2 = (Snake) s.clone();
		Prt.outln("s2=" + s2);
		s.increment();
		Prt.outln("after s.increment,s2 = " + s2);
		Prt.outln("after s.increment,s = " + s);
		s2.increment();
		Prt.outln("after s.increment,s2 = " + s2);
		Prt.outln("after s.increment,s = " + s);
	}

} // /:~
