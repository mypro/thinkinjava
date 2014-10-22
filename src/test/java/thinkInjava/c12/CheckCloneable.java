package thinkInjava.c12;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

//: Compete.java 

class Ordinary {
}

class WrongClone extends Ordinary {
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class IsCloneable extends Ordinary implements Cloneable {
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class NoMore extends IsCloneable {
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}

class TryMore extends NoMore {
	public Object clone() throws CloneNotSupportedException {
		// Calls NoMore.clone(), throws exception:
		return super.clone();
	}
}

class BackOn extends NoMore {
	private BackOn duplicate(BackOn b) {
		// Somehow make a copy of b
		// and return that copy. This is a dummy
		// copy, just to make the point:
		return new BackOn();
	}

	public Object clone() {
		// Doesn't call NoMore.clone():
		return duplicate(this);
	}
}

final class ReallyNoMore extends NoMore {
}

public class CheckCloneable {

	public static Ordinary tryToClone(Ordinary ord) {
		String id = ord.getClass().getName();
		Ordinary x = null;
		if (ord instanceof Cloneable) {
			try {
				System.out.println("Attemping " + id);
				x = (Ordinary) ((IsCloneable) ord).clone();
				System.out.println("cloned " + id);

			} catch (CloneNotSupportedException e) {
				System.out.println("Could not clone " + id);
			}

		}
		return x;
	}

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

	public static void main(String[] args) {
		// Upcasting:
		Ordinary[] ord = { new IsCloneable(), new WrongClone(), new NoMore(),
				new TryMore(), new BackOn(), new ReallyNoMore(), };
		Ordinary x = new Ordinary();
		// This won't compile, since clone() is
		// protected in Object:
		// ! x = (Ordinary)x.clone();
		// tryToClone() checks first to see if
		// a class implements Cloneable:
		for (int i = 0; i < ord.length; i++) {
			tryToClone(ord[i]);
		}
	}

	@Test
	public void testName() throws Exception {
		Ordinary[] ord = { new IsCloneable(), new WrongClone(), new NoMore(),
				new TryMore(), new BackOn(), new ReallyNoMore() };
		Ordinary x = new Ordinary();
		for (int i = 0; i < ord.length; i++) {
			tryToClone(ord[i]);
		}
	}

}
