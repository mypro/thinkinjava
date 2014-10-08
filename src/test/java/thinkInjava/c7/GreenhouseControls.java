package thinkInjava.c7;

public class GreenhouseControls extends Controller {
	private boolean light = false;
	private boolean water = false;
	private boolean fan = false;
	private String thermostat = "Day";

	private class LightOn extends Event {
		public LightOn(long eventTime) {
			super(eventTime);
		}

		@Override
		public void action() {
			// Put hardware control code here to
			// physically turn on the light.
			light = true;
		}

		@Override
		public String description() {
			return "Light is on";
		}
	}

	private class LightOff extends Event {
		public LightOff(long eventTime) {
			super(eventTime);
		}

		@Override
		public void action() {
			// Put hardware control code here to
			// physically turn off the light.
			light = false;
		}

		@Override
		public String description() {
			return "Light is off";
		}
	}

	private class WaterOn extends Event {
		public WaterOn(long eventTime) {
			super(eventTime);
		}

		@Override
		public void action() {
			// Put hardware control code here
			water = true;
		}

		@Override
		public String description() {
			return "Greenhouse water is on";
		}
	}

	private class WaterOff extends Event {
		public WaterOff(long eventTime) {
			super(eventTime);
		}

		@Override
		public void action() {
			// Put hardware control code here
			water = false;
		}

		@Override
		public String description() {
			return "Greenhouse water is off";
		}
	}

	private class ThermostatNight extends Event {
		public ThermostatNight(long eventTime) {
			super(eventTime);
		}

		@Override
		public void action() {
			// Put hardware control code here
			thermostat = "Night";
		}

		@Override
		public String description() {
			return "Thermostat on night setting";
		}
	}

	private class ThermostatDay extends Event {
		public ThermostatDay(long eventTime) {
			super(eventTime);
		}

		@Override
		public void action() {
			// Put hardware control code here
			thermostat = "Day";
		}

		@Override
		public String description() {
			return "Thermostat on day setting";
		}
	}

	private class FanOn extends Event {
		public FanOn(long eventTime) {
			super(eventTime);
		}

		@Override
		public void action() {
			// Put hardware control code here
			fan = true;
		}

		@Override
		public String description() {
			return "fan is on";
		}
	}

	private class FanOff extends Event {
		public FanOff(long eventTime) {
			super(eventTime);
		}

		@Override
		public void action() {
			// Put hardware control code here
			fan = false;
		}

		@Override
		public String description() {
			return "fan is off";
		}
	}

	// An example of an action() that inserts a
	// new one of itself into the event list:
	private int rings;

	private class Bell extends Event {
		public Bell(long eventTime) {
			super(eventTime);
		}

		@Override
		public void action() {
			// Ring bell every 2 seconds, rings times:
			System.out.println("Bing!");
			if (--rings > 0) {
				addEvent(new Bell(System.currentTimeMillis() + 2000));
			}
		}

		@Override
		public String description() {
			return "Ring bell";
		}
	}

	private class Restart extends Event {
		public Restart(long eventTime) {
			super(eventTime);
		}

		@Override
		public void action() {
			long tm = System.currentTimeMillis();
			// Instead of hard-wiring, you could parse
			// configuration information from a text
			// file here:
			rings = 3;
			addEvent(new ThermostatNight(tm));
			addEvent(new LightOn(tm + 1000));
			addEvent(new LightOff(tm + 2000));
			addEvent(new WaterOn(tm + 3000));
			addEvent(new WaterOff(tm + 8000));
			addEvent(new FanOn(tm + 1000));
			addEvent(new FanOff(tm + 1000));
			addEvent(new Bell(tm + 9000));
			addEvent(new ThermostatDay(tm + 10000));
			// Can even add a Restart object!
			addEvent(new Restart(tm + 20000));
			System.out.println("-----------------");
		}

		@Override
		public String description() {
			return "Restarting system";
		}
	}

	public static void main(String[] args) {
		GreenhouseControls gc = new GreenhouseControls();
		long tm = System.currentTimeMillis();
		gc.addEvent(gc.new Restart(tm));
		gc.run();
	}
} // /:~
