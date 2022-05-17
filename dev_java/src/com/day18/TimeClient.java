package com.day18;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JLabel;

public class TimeClient extends Thread {

	private JLabel label;

	public TimeClient() {
	}

	public TimeClient(JLabel label) {
		System.out.println("label:" + label);
		this.label = label;
	}

	// run() 시작
	public void run() {

		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		String timeStr = null;

		try {
			//클라이언트측에서 아래  인스턴스화가 실행되면 ServerSocket 에 정보가 전달 됨- 접속이 됨
			//1. 서버측의 아이피 주소를 넣어야 한다. 두번째는 포트번호
			// localhost == 127.0.0.1 로컬 host이름이다.
			socket = new Socket("127.0.0.1", 9002);
			//생성된 소켓이 있어야 출력을 담당하는 객체 생성할 수 있다.
			//생성자 파라미터자리에 소켓.getOutputStream()으로 객체생성됨 - 말하기 -쓰기(현재시간정보를 소켓에 쓴다)
			oos = new ObjectOutputStream(socket.getOutputStream());
			// 서버측에서 보낸 메시지를 읽어오는데 사용한다.- 객체를 생성할 때 반드시 Socket객체가 생성되어 있어야 함.
			ois = new ObjectInputStream(socket.getInputStream());
			while (true) {
				timeStr = ois.readObject().toString();
				//System.out.println(timeStr);
				label.setText(timeStr);
				// Thread.yield();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException i) {
				}
			}
		} catch (IOException i) {
			label.setText("타임서버에 접속할 수 없습니다.");
		} catch (Exception e) {

		} finally {
			try {
				ois.close();
				oos.close();
				socket.close();
			} catch (IOException e) {
			}
		}
	}

	// run() 종료
	public static void main(String args[]) {
		// 여러 스레드가 중지 상태 혹은 준비상태에 있을 수 있어서 순서를 따진 후
		// 실행되어야 한다.
		TimeClient tc = new TimeClient();
		tc.start();// run()호출이 된다. - Thread검색 start()

	}

}
