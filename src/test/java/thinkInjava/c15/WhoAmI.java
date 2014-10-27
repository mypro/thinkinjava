package thinkInjava.c15;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class WhoAmI {
	public static void main(String[] args) throws UnknownHostException {
		if (args.length != 1) {
			System.out.println("Usage : WhoAmI MachineName");
			System.exit(1);
		}
		InetAddress a = InetAddress.getByName(args[0]);
		System.out.println(a);
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################");
	}

	@Test
	public void test() throws Exception {
		String name = "chenwc-PC";
		InetAddress a = InetAddress.getByName(name);
		System.out.println(a);
		InetAddress[] b = InetAddress.getAllByName(name);
		System.out.println(JSON.toJSONString(b));
	}
}
