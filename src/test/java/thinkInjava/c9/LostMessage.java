package thinkInjava.c9;

//: LostMessage.java
//How an exception can be lost

class VeryImportantException extends Exception {
	@Override
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	@Override
	public String toString() {
		return "A trivial exception";
	}
}

public class LostMessage {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

	public static void main(String[] args) throws Exception {
		LostMessage lm = new LostMessage();
		try {
			lm.f();
			// } catch (VeryImportantException e) {
			// e.printStackTrace();
		} finally {
			// lm.dispose();
			System.out.println("finally");
		}
		System.out.println("end");
	}
} // /:~
