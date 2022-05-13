package com.day18;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread {
	// 이소켓은 null인데 oos, ois를 인스턴스화 할 수 있나요? 아니아니
	Socket 					client 	= null;
	ObjectOutputStream 		oos 	= null;
	ObjectInputStream 		ois 	= null;
	String 			        nickName = null;
	// 파라미터에 선언된 객체는 TalkServer객체주소번지를 갖는다
	public TalkServerThread(TalkServer ts) {
		this.client = ts.client;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			//100#nickName
			String msg = (String)ois.readObject();
			oos.writeObject(msg);
			StringTokenizer st = new StringTokenizer(msg,"#");
			st.nextToken();//100
			nickName = st.nextToken();
			ts.jta_log.append(nickName+"님 입장하였습니다.\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
}
