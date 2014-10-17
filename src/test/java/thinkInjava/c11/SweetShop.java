package thinkInjava.c11;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myutil.Prt;

class Candy {
	static {
		Prt.outln("Loading Candy");
	}
}

class Gum {
	static {
		Prt.outln("Loading Gum");
	}
}
class Cookie {
	static {
		Prt.outln("Loading Cookie");
	}
}
public class SweetShop {
static {
	Prt.outln("init static SweetShop");
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
		Prt.outln(" inside main");
		new Candy();
		Prt.outln(" After creating Candy");
		try{
			Class.forName("Gum");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Prt.outln("After Class.forName(\"Gum\")");

		new Cookie();
		Prt.outln("After creating Cookie");
	}
} // /:~
