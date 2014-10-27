package thinkInjava.c13;

//: Applet3.java
//Shows init(), start() and stop() activities
import java.applet.Applet;
import java.awt.Graphics;

public class Applet3 extends Applet {
	String s;
	int inits = 0;
	int starts = 0;
	int stops = 0;

	@Override
	public void init() {
		inits++;
	}

	@Override
	public void start() {
		starts++;
	}

	@Override
	public void stop() {
		stops++;
	}

	@Override
	public void paint(Graphics g) {
		s = "inits: " + inits + ", starts: " + starts + ", stops: " + stops;
		g.drawString(s, 10, 10);
	}
} // /:~
