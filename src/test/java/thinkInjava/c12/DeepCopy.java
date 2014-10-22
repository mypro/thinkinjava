//: Alias1.java
package thinkInjava.c12;

import org.junit.Test;

class DepthReading implements Cloneable {
	private double depth;

	public DepthReading(double depth) {
		this.depth = depth;
	}

	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}
}

class TemperatureReading implements Cloneable {
	private long time;
	private double temperature;

	public TemperatureReading(double temperature) {
		time = System.currentTimeMillis();
		this.temperature = temperature;
	}

	@Override
	public Object clone() {

		Object o = null;
		try {
			o = super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}
}

class OceanReading implements Cloneable {
	private DepthReading depth;
	private TemperatureReading temperature;

	public OceanReading(double tdata, double ddate) {
		temperature = new TemperatureReading(tdata);
		depth = new DepthReading(ddate);

	}

	@Override
	public Object clone() {

		Object o = null;
		try {
			o = super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}

}

public class DeepCopy {

	public static void main(String[] args) {

	}

	@Test
	public void testName() throws Exception {
		OceanReading reading = new OceanReading(33.9, 100.5);
		// Now clone it:
		OceanReading r = (OceanReading) reading.clone();
		System.out.println(r);
	}
} // /:~
