package network.step4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class UnicastClient {
	private String ip;
	private int port;
	private String message;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	Scanner scan = new Scanner(System.in);
	public UnicastClient(String ip, int port) throws Exception {
		this.ip = ip;
		this.port = port;
		boolean isStop = false;
		Socket tcpSocket = getSocket();
		oos = new ObjectOutputStream(tcpSocket.getOutputStream());
		ois = new ObjectInputStream(tcpSocket.getInputStream());
		while(!isStop) {
			System.out.print("message : ");
			message =scan.next();
			oos.writeObject(message);
			
			message = (String)ois.readObject();
			if("exit".equals(message)) {
				isStop = true;
				System.out.println("종료되었습니다.");
			}else {
				System.out.println("Received message : " + message);
			}
		}
	}
	public Socket getSocket() {
		Socket tcpSocket = null;
		try {
			tcpSocket = new Socket(ip, port);
		} catch (IOException ie) {
			ie.printStackTrace();
			System.exit(0);
		}
		return tcpSocket;
	}
	public static void main(String args[]) throws Exception{
		new UnicastClient("192.168.40.3", 3000);
	}
}
