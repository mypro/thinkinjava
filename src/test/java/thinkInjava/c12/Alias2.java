//: Alias1.java
package thinkInjava.c12;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myutil.Prt;

public class Alias2 {
	private int i;

	public void setValue(int ii) {
		this.i = ii;
	}
	public static void f(Alias2 handle){
		handle.i++;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Prt.outln("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Prt.outln("AfterClass test##########################################");
	}


	@Test
	public void test() {
		Alias2 x = new Alias2();
		x.setValue(8);
		Prt.outln("x : " + x.i);
		Prt.outln("Incrementing x");
		f(x);
		Prt.outln("x : " + x.i);

	}
} // /:~
