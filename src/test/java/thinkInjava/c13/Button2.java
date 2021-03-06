package thinkInjava.c13;

//: Button2.java
//Capturing button presses
import java.applet.Applet;
import java.awt.Button;
import java.awt.Event;

public class Button2 extends Applet {
	Button b1 = new Button("Button 1"), b2 = new Button("Button 2");

	@Override
	public void init() {
		add(b1);
		add(b2);
	}

	@Override
	public boolean action(Event evt, Object arg) {
		if (evt.target.equals(b1)) {
			getAppletContext().showStatus("Button 1");
		} else if (evt.target.equals(b2)) {
			getAppletContext().showStatus("Button 2");
			// Let the base class handle it:
		} else {
			return super.action(evt, arg);
		}
		return true; // We've handled it here
	}
} // /:~
