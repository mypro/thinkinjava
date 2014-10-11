package thinkInjava.c8;

//: CrashJava.java
//One way to crash Java
import java.util.Vector;

public class CrashJava {
	@Override
	public String toString() {
		// return "CrashJava address: " + this + "\n";
		return "CrashJava address: " + super.toString() + "\n";
	}

	public static void main(String[] args) {
		Vector v = new Vector();
		for (int i = 0; i < 10; i++) {
			v.addElement(new CrashJava());
		}
		System.out.println(v);
	}
} // /:~
