package thinkInjava.c8;

import java.util.Vector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

class Cat {
	private int catNumber;

	Cat(int i) {
		catNumber = i;
	}

	void print() {
		System.out.println("Cat #" + catNumber);
	}
}

class Dog {
	private int dogNumber;

	Dog(int i) {
		dogNumber = i;
	}

	void print() {
		System.out.println("Dog #" + dogNumber);
	}
}

public class CatsAndDogs {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##############################################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################################");
	}

	@Test
	public void test() {

		Vector cats = new Vector();
		for (int i = 0; i < 7; i++) {
			cats.addElement(new Cat(i));
		}
		cats.addElement(new Dog(7));
		for (int i = 0; i < cats.size(); i++) {
			((Cat) cats.elementAt(i)).print();
		}
	}
}
