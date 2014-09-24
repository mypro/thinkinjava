package com.test;

import java.util.Formatter;
import java.util.Locale;

public class Demo {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		// Send all output to the Appendable object sb
		Formatter formatter = new Formatter(sb, Locale.US);
		System.out.println(formatter.format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d"));

	}
}
