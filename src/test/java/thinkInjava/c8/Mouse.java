package thinkInjava.c8;

public class Mouse {
	private int mouseNumber;

	Mouse(int i) {
		mouseNumber = i;
	}

	@Override
	public String toString() {
		return "This is Mouse #" + mouseNumber;
	}

	void print(String msg) {
		if (msg != null) {
			System.out.println(msg);
		}
		System.out.println("Mouse number #" + mouseNumber);
	}
}