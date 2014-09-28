package thinkInjava.c6;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class WaterSource {
	private String s;

	WaterSource() {
		System.out.println("WaterSource");
		s = new String("Constructed");
	}

	@Override
	public String toString() {
		return s;
	}
}

public class SprinklerSystem {
	private static Logger logger = LoggerFactory.getLogger(SprinklerSystem.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################");
	}

	private String valve1, valve2, valve3, valve4;
	WaterSource source;
	int i;
	float f;

	void print() {
		System.out.println("valve1 = " + valve1);
		System.out.println("valve2 = " + valve2);
		System.out.println("valve3 = " + valve3);
		System.out.println("valve4 = " + valve4);
		System.out.println("i = " + i);
		System.out.println("f = " + f);
		System.out.println("source = " + source);

	}

	@Test
	public void testMain() {
		SprinklerSystem x = new SprinklerSystem();
		x.print();
	}
}
