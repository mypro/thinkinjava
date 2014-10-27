package thinkInjava.c13;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Apptest {

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
	}
}
