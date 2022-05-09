package network.step5;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer {
	private ArrayList<MultiServerThread> list = null;
	private Socket socket = null;
	public MultiServer() {
		list = new ArrayList<>();
		try {
			ServerSocket server = new ServerSocket(5000);
			MultiServerThread mst = null;
			boolean isStop = false;
			while(!isStop) {
				System.out.println("Server ready ...");
				socket = server.accept();
				mst = new MultiServerThread(this);
				list.add(mst);
				Thread t = new Thread(mst);
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<MultiServerThread> getList(){
		return list;
	}
	public Socket getSocket() {
		return socket;
	}
	public static void main(String[] args) {
		new MultiServer();
	}

}
