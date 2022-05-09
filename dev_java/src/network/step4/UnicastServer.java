package network.step4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UnicastServer {
	private ServerSocket server;
	public UnicastServer(int port) {
		try {
			server = new ServerSocket(port);
		} catch (IOException ie) {
			ie.printStackTrace();
			System.exit(0);
		}
		UnicastServerThread ust = null;
		while(true) {
			System.out.println("클라이언트 대기 중");
			Socket s = null;
			try {
				s = server.accept();
			} catch (IOException ie) {
				ie.printStackTrace();
			}
			System.out.println("client ip : "+s.getInetAddress().getHostAddress());
			ust = new UnicastServerThread(s);
			Thread t = new Thread(ust);
			t.start();
		}
	}
	public static void main(String[] args) {
		new UnicastServer(3000);
	}

}
