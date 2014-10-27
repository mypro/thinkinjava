package thinkInjava.c13;

import java.applet.Applet;
import java.awt.Graphics;

public class Applet2 extends Applet {

	@Override
	public void paint(Graphics g) {
		g.drawString("my applet", 10, 10);
		g.draw3DRect(0, 0, 100, 20, true);
	}
}
