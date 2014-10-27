package thinkInjava.c12;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Vector;
import com.alibaba.fastjson.JSON;

public class ImmutableInteger{


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

		Vector v = new Vector();
		for (int i = 0; i < 10; i++) {
			v.addElement(new Integer(i));
		}
		System.out.println(JSON.toJSONString(v));
	}
} // /:~
