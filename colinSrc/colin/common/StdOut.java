package colin.common;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public final class StdOut {

	// force Unicode UTF-8 encoding; otherwise it's system dependent
	private static final String CHARSET_NAME = "UTF-8";

	// assume language = English, country = US for consistency with StdIn
	private static final Locale LOCALE = Locale.US;

	// send output here
	private static PrintWriter out;

	// this is called before invoking any methods
	static {
		try {
			out = new PrintWriter(new OutputStreamWriter(System.out,
					CHARSET_NAME), true);
		} catch (UnsupportedEncodingException e) {
			System.out.println(e);
		}
	}

	// don't instantiate
	private StdOut() {
	}

	// close the output stream (not required)
	public static void close() {
		out.close();
	}

	public static void println() {
		out.println();
	}

	public static void println(Object x) {
		out.println(x);
	}

	public static void println(boolean x) {
		out.println(x);
	}

	public static void println(char x) {
		out.println(x);
	}

	public static void println(double x) {
		out.println(x);
	}

	public static void println(float x) {
		out.println(x);
	}

	public static void println(int x) {
		out.println(x);
	}

	public static void println(long x) {
		out.println(x);
	}

	public static void println(short x) {
		out.println(x);
	}

	public static void println(byte x) {
		out.println(x);
	}

	public static void print() {
		out.flush();
	}

	public static void print(Object x) {
		out.print(x);
		out.flush();
	}

	public static void print(boolean x) {
		out.print(x);
		out.flush();
	}

	public static void print(char x) {
		out.print(x);
		out.flush();
	}

	public static void print(double x) {
		out.print(x);
		out.flush();
	}

	public static void print(float x) {
		out.print(x);
		out.flush();
	}

	public static void print(int x) {
		out.print(x);
		out.flush();
	}

	public static void print(long x) {
		out.print(x);
		out.flush();
	}

	public static void print(short x) {
		out.print(x);
		out.flush();
	}

	public static void print(byte x) {
		out.print(x);
		out.flush();
	}

	public static void printf(String format, Object... args) {
		out.printf(LOCALE, format, args);
		out.flush();
	}

	public static void printf(Locale locale, String format, Object... args) {
		out.printf(locale, format, args);
		out.flush();
	}

	// This method is just here to test the class
	public static void main(String[] args) {
		// write to stdout
		StdOut.println("Test");
		StdOut.println(17);
		StdOut.println(true);
		StdOut.printf("%.6f\n", 1.0 / 7.0);
	}

}
