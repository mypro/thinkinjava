package thinkInjava.c10;

import java.io.File;
import java.io.FilenameFilter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import thinkInjava.c08.StrSortVector;

import com.myutil.Prt;

public class SortedDirList {

	private File path;
	private String[] list;

	public SortedDirList(final String afn) {
		path = new File(".");

		if (afn == null) {
			list = path.list();
		} else {
			list = path.list(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String n) {
					String f = new File(n).getName();
					return f.indexOf(afn) != -1;
				}
			});
		}
		sort();

	}

	public void print() {
		for (String element : list) {
			System.out.println(element);
		}
	}

	public void sort() {
		StrSortVector sv = new StrSortVector();
		for (String element : list) {
			sv.addElement(element);
		}
		for (int i = 0; i < list.length; i++) {
			list[i] = sv.elementAt(i);
		}
	}

	public static void main(String[] args) {
		SortedDirList sd;
		if (args.length == 0) {
			sd = new SortedDirList(null);
		} else {
			sd = new SortedDirList(args[0]);
		}
		sd.print();
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Prt.outln("beforeClass test##############################################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Prt.outln("AfterClass  test##############################################################");
	}

	@Test
	public void test() {
		SortedDirList sd;
		String[] param = new String[] {};
		if (param.length == 0) {
			sd = new SortedDirList(null);
		} else {
			sd = new SortedDirList(param[0]);
		}
		sd.print();

	}
}
