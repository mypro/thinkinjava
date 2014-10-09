package thinkInjava.c8;

import java.util.Vector;
import java.util.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

class Mouse {
	private int mouseNumber;

	Mouse(int i) {
		mouseNumber = i;
	}

	public String toString(){
		return "This is Mouse #" + mouseNumber;
	}

	void print(String msg) {
		if(msg != null) System.out.println(msg);
		System.out.println("Mouse number #" + mouseNumber);
	}
}

class MouseTrap {
	static void caughtYa(Object m){
		Mouse mouse = (Mouse)m;
		mouse.print("Caught one!");
	}

}

public class WorksAnyway {
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

		Vector mice = new Vector();
		for (int i = 0;i<3;i++) {
			mice.addElement(new Mouse(i));
		}
		for (int i=0;i<mice.size();i++ ) {
			System.out.println("Free mouse : "+mice.elementAt(i));
			MouseTrap.caughtYa(mice.elementAt(i));
		}

	}
}
