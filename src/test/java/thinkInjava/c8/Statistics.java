package thinkInjava.c8;

import java.util.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


class Counter {
	int i = 1;
	public String toString(){
		return Integer.toString(i);
	}
}
public class Statistics {




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
		Hashtable ht = new Hashtable();
		for (int i = 0; i< 10000; i++ ) {

			Integer r = new Integer((int)(Math.random() * 20));
			if (ht.containsKey(r)) {
				((Counter)ht.get(r)).i++;
			}else{
				ht.put(r, new Counter());
			}
		}
			System.out.println(ht);

	}
}
