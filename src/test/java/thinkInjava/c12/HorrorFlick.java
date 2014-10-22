package thinkInjava.c12;

//: Compete.java 
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

class Person {
}

class Hero extends Person {
}

class Scientist extends Person implements Cloneable {
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// this should never happen:
			// It's Cloneable already!
			throw new InternalError();
		}
	}
}

class MadScientist extends Scientist {
}

public class HorrorFlick {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out
				.println("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out
				.println("AfterClass test##########################################");
	}

	@Test
	public void testName() throws Exception {
		Person p = new Person();
		Hero h = new Hero();
		Scientist s = new Scientist();
		MadScientist m = new MadScientist();
		s = (Scientist) s.clone();
		m = (MadScientist) m.clone();
	}
}