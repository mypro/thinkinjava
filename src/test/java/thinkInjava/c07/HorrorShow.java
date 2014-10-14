package thinkInjava.c07;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Monster {
	void menace();
}

interface DangerousMonster extends Monster {
	void destroy();
}

interface Lethal {
	void kill();
}

class DragonZilla implements DangerousMonster {
	@Override
	public void menace() {
		System.out.println("menace");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}
}

interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}

public class HorrorShow {
	private static Logger logger = LoggerFactory.getLogger(HorrorShow.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################");
	}

	static void u(Monster b) {
		b.menace();
	}

	static void v(DangerousMonster d) {
		d.menace();
		d.destroy();
	}

	public static void main(String[] args) {
		DragonZilla if2 = new DragonZilla();
		u(if2);
		v(if2);

	}

	@Test
	public void testmain() {
		DragonZilla if2 = new DragonZilla();
		u(if2);
		v(if2);
	}
}
