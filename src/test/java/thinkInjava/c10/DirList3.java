
package thinkInjava.c10;

import java.io.File;
import java.io.FilenameFilter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myutil.Prt;

// class DirFilter implements FilenameFilter {
// 	String afn;

// 	DirFilter(String afn) {
// 		this.afn = afn;
// 	}

// 	@Override
// 	public boolean accept(File dir, String name) {
// 		String f = new File(name).getName();
// 		return f.indexOf(afn) != -1;
// 	}
// }

public class DirList3 {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Prt.outln("before test##############################################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Prt.outln("AfterClass test##########################################################");
	}

	@Test
	public void test() {
		try {
			final String[] param = new String[] {"i"};
			// String[] param = new String[] { "git" };
			File path = new File(".");
			String[] list;
			if (param.length == 0) {
				list = path.list();
			} else {
				list = path.list(new FilenameFilter(){
					public boolean accept(File dir,String n){
						String f = new File(n).getName();
						return f.indexOf(param[0]) != -1;
					}
				});
			}
			for (String element : list) {
				Prt.outln(element);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
