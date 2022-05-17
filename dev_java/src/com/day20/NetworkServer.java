package com.day20;

import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer {
	public void serverUp() {
		int port = 3000;
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("server : "+server);
			while(true) {
				Socket client = server.accept();
				System.out.println("client socket : "+client);
			}
		} catch (Exception e) {
			e.printStackTrace();// 라인번호와 함께 메시지 출력
		}
	}
	public static void main(String[] args) {
		NetworkServer ns = new NetworkServer();
		ns.serverUp();
	}

}
