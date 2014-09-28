package thinkInjava.c5.dessert;

import com.alibaba.fastjson.JSON;

public class Dinner {
	private Dinner() {
		System.out.println("new Dinner");
	}

	public static Dinner makeDinner() {
		System.out.println("MAKE DINNER");
		return new Dinner();
	}

	public static void main(String[] args) {
		Cookie ck = new Cookie();
		ck.foo();
		ck.name1 = "aa";
		ck.name2 = "aa";
		ck.name3 = "aa";
		// ck.name4 = "aa"; 不可见
		System.out.println(JSON.toJSONString(ck));
	}
}
