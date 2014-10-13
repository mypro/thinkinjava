package thinkInjava.c9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myutil.Prt;

class InputFile {
	private BufferedReader in;

	InputFile(String fname) throws Exception {
		try {
			in = new BufferedReader(new FileReader(fname));
		} catch (FileNotFoundException e) {
			Prt.outln("Could not open " + fname);
			throw e;
		} catch (Exception e) {
			try {
				in.close();
			} catch (IOException e2) {
				Prt.outln("in.close() unsuccessful");
			}
			throw e;
		} finally {
			// Don't close it here !!!
		}
	}

	String getLine() {
		String s;
		try {
			s = in.readLine();
		} catch (IOException e) {
			Prt.outln("readLine() unsuccessful");
			s = "failed";
		}
		return s;
	}

	void cleanup() {
		try {
			in.close();
		} catch (IOException e2) {
			System.out.println("in.close() unsuccessful");
		}
	}

}

public class Cleanup {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################");
	}

	public static void main(String[] args) {
		try {
			InputFile in = new InputFile("Cleanup.java");
			String s;
			int i = 1;
			while ((s = in.getLine()) != null) {
				System.out.println("" + i++ + ": " + s);
			}
			in.cleanup();
		} catch (Exception e) {
			System.out.println("Caught in main, e.printStackTrace()");
			e.printStackTrace();
		}

	}

	@Test
	public void test() {
		try {
			InputFile in = new InputFile("Cleanup.java");
			String s;
			int i = 1;
			while ((s = in.getLine()) != null) {
				Prt.outln("" + i++ + ": " + s);
			}
			in.cleanup();
		} catch (Exception e) {
			Prt.outln("Caught in test, e.printStackTrace()");
			e.printStackTrace();
		}

	}
} // /:~
