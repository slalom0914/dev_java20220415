package backend.thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JLabel;

public class TimeClient extends Thread {

	private JLabel label;
	
	public TimeClient(){}
	
	public TimeClient(JLabel label) {
		System.out.println("label:"+label);
		this.label = label;
	}

	// run() 시작
	public void run() {

		Socket socket = null;
		ObjectOutputStream  oos = null;
		ObjectInputStream  ois = null;
		String timeStr = null;
   
		try {
			
			socket = new Socket("localhost", 2008);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			while(true) {
				timeStr = ois.readObject().toString();
			    System.out.println(timeStr);
				label.setText(timeStr);
				//Thread.yield();
				try {
					Thread.sleep(1000);
				} catch(InterruptedException i) {
 			    } 
			}
		} catch(IOException i) {
			label.setText("타임서버에 접속할 수 없습니다.");
		} catch(Exception e) {
			
		} finally {
			try {
				ois.close();
				oos.close();
				socket.close();
			} catch (IOException e) {}
		}
	}
	
	// run() 종료
	public static void main(String args[]){
		TimeClient tc = new TimeClient();
		tc.start();
		
	}

}
