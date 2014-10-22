//: Alias1.java
package thinkInjava.c12;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myutil.Prt;

public class Alias1 {
	private int i;

	public void setValue(int ii) {
		this.i = ii;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Prt.outln("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Prt.outln("AfterClass test##########################################");
	}

	public static void main(String[] args) {
		Alias1 x = new Alias1();
		x.setValue(8);
		Alias1 y = x;
		Prt.outln("x : " + x.i);
		Prt.outln("y : " + y.i);
		Prt.outln("Incrementing x");
		x.i++;
		Prt.outln("x : " + x.i);
		Prt.outln("y : " + y.i);
	}

	@Test
	public void test() {
		Alias1 x = new Alias1();
		x.setValue(8);
		Alias1 y = x;
		Prt.outln("x : " + x.i);
		Prt.outln("y : " + y.i);
		Prt.outln("Incrementing x");
		x.i++;
		Prt.outln("x : " + x.i);
		Prt.outln("y : " + y.i);

	}
} // /:~
