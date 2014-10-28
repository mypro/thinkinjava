package thinkInjava.c15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

class JabberClientThread extends Thread {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	private static int counter = 0;
	private int id = counter++;
	private static int threadCount = 0;

	public static int threadCount() {
		return threadCount;
	}

	public JabberClientThread(InetAddress addr) {
		System.out.println("Making client " + id);
		threadCount++;
		try {

			socket = new Socket(addr, MultiJabberServer.PORT);
		} catch (IOException e) {
		}

		try {

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			start();
		} catch (IOException e) {
			try {
				socket.close();
			} catch (IOException ee) {

			}

		}
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 25; i++) {
				out.println("Client " + id + ": " + i);
				String str = in.readLine();
				System.out.println("str");
			}
		} catch (IOException e) {

		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				threadCount--;
			}
		}
	}
}

public class MultiJabberClient extends Thread {
	static final int MAX_THREADS = 40;

	public static void main(String[] args) throws IOException, InterruptedException {

		InetAddress addr = InetAddress.getByName(null);

		while (true) {
			if (JabberClientThread.threadCount() < MAX_THREADS) {
				new JabberClientThread(addr);
				Thread.currentThread().sleep(100);
			}
		}

	}
}
