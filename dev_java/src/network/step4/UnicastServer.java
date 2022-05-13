package network.step4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * 서버측에서는 클라이언트에서 들은 걸 전달만 합니다.
 * 서버측에서는 말하기가 필요하지 않습니다.
 * 클라이언트측에서 하는 말을 서버가 들은 후 클라이언트측에 내보내게 됩니다.
 * 
 */
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
