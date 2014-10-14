package thinkInjava.c08;

import java.util.Stack;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Stacks {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##############################################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################################");
	}

	static String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };

	@Test
	public void test() {

		Stack stk = new Stack();
		for (String month : months) {
			stk.push(month + " ");
		}
		System.out.println("stk = " + stk);
		stk.addElement("The last line");
		System.out.println("element 5 =" + stk.elementAt(5));
		System.out.println("popping elements:");
		while (!stk.empty()) {
			System.out.println(stk.pop());
		}

	}
}
