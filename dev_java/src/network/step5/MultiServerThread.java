package network.step5;

public class MultiServerThread extends Thread {
	MultiServer multiServer = null;
	public MultiServerThread(MultiServer multiServer) {
		this.multiServer = multiServer;
	}

}
