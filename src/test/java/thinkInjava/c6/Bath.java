package thinkInjava.c6;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

//: Bath.java
// Constructor initialization with composition

class Soap {
	private String s;

	Soap() {
		System.out.println("Soap()");
		s = new String("Constructed");
	}

	@Override
	public String toString() {
		return s;
	}
}

public class Bath {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################");
	}

	private String s1 = new String("Happy"), s2 = "Happy birthday", s3, s4;
	Soap castille;
	int i;
	float toy;

	public Bath() {
		System.out.println("Inside Bath()");
		s3 = new String("Joy");
		i = 47;
		toy = 3.14f;
		castille = new Soap();

	}

	void print() {
		if (s4 == null) {
			s4 = new String("Joy");
		}
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
		System.out.println("s4 = " + s4);
		System.out.println("i = " + i);
		System.out.println("toy = " + toy);
		System.out.println("castille = " + castille);

	}

	@Test
	public void testBath() {
		System.out.println("testBath----------------");
		Bath b = new Bath();

	}

	@Test
	public void testBath1() {
		System.out.println("testBath1---------------");
		Bath b = new Bath();

	}

	@Test
	public void testBath2() {
		System.out.println("testBath2---------------");
		Bath b = new Bath();

	}

	public static void main(String[] args) {
		Bath b = new Bath();
		b.print();
	}
}
