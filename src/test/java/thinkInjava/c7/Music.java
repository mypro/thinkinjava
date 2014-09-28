package thinkInjava.c7;

class Note {
	private int value;

	private Note(int val) {
		value = val;
	}

	public static final Note middleC = new Note(0), cSharp = new Note(1), cFlat = new Note(2);
}

class Instrument {
	public void play(Note n) {
		System.out.println("Instrument.play()");
	}
}

class Wind extends Instrument {
	@Override
	public void play(Note n) {
		System.out.println("Wind.play()");
	}
}

class Stringed extends Instrument {
	@Override
	public void play(Note n) {
		System.out.println("Stringed.play()");
	}
}

class Brass extends Instrument {
	@Override
	public void play(Note n) {
		System.out.println("Brass.play()");
	}
}

public class Music {
	// public static void tune(Instrument i) {
	// i.play(Note.middleC);
	// }

	public static void tune(Wind i) {
		i.play(Note.middleC);
	}

	public static void tune(Stringed i) {
		i.play(Note.middleC);
	}

	public static void tune(Brass i) {
		i.play(Note.middleC);
	}

	public static void main(String[] args) {
		Wind flute = new Wind();
		Stringed violin = new Stringed();
		Brass frenchHorn = new Brass();
		tune(flute); // No upcasting
		tune(violin);
		tune(frenchHorn);

	}
}
