package network.step4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class UnicastServerThread implements Runnable {
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private String message;
	public UnicastServerThread(Socket s) {
		this.socket = s;
	}

	@Override
	public void run() {
		boolean isStop = false;
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException ie) {
			isStop =true;
		}
		
		try {
			while(!isStop) {
				String message = (String)ois.readObject();
				if("exit".equals(message)) isStop = true;
				System.out.println("received message : " + message);
				oos.writeObject(message);
			}
		} catch (Exception ie) {
			System.out.println("클라이언트가 강제로 종료되었습니다.");
			isStop = true;
		} finally {
			try {
				if(ois !=null) ois.close();
				if(oos !=null) oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
