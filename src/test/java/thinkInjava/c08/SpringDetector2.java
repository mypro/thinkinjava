package thinkInjava.c08;

//: SpringDetector2.java
//If you create a class that's used as a key in
//a Hashtable, you must override hashCode()
//and equals().
import java.util.Hashtable;

class Groundhog2 {
	int ghNumber;

	Groundhog2(int n) {
		ghNumber = n;
	}

	@Override
	public int hashCode() {
		return ghNumber;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Groundhog2 && ghNumber == ((Groundhog2) o).ghNumber;
	}
}

public class SpringDetector2 {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		for (int i = 0; i < 10; i++) {
			ht.put(new Groundhog2(i), new Prediction());
		}
		System.out.println("ht = " + ht + "\n");
		System.out.println("Looking up prediction for groundhog #3:");
		Groundhog2 gh = new Groundhog2(3);
		if (ht.containsKey(gh)) {
			System.out.println(ht.get(gh));
		}
	}
} // /:~
