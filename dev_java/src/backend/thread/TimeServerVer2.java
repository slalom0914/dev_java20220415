package backend.thread;

import java.net.*;
import java.io.*;
import java.util.*;

public class TimeServerVer2 extends Thread {

	private Socket socket;
	public TimeServerVer2() {
	}
	@Override
	public void run() {
		int port = 2008;
		ServerSocket server = null;
		Socket client = null;
		try {
			server = new ServerSocket(port);
		} catch(IOException e) {
			// 이미 할당된 포트번호인 경우 예외 발생함
			System.out.println("Can't bind port: " + port);
			e.printStackTrace();
			try {
				server.close();
			} catch(IOException i) {}
			// 자바가상머신과의 연결고리를 끊어버림 - 실제로 어플리케이션 종료됨
			System.exit(0);
		}
		// 아래가 출력되면 타입서버가 정상적으로 기동된 상태를 의미함
		System.out.println("Time Server started successfully...");
		boolean isStop = false;
		while(!isStop) {
			try {
				client = server.accept();
				System.out.println("New Client connected...");
				TimeServer tServer = new TimeServer(client);
				tServer.start();
				System.out.println("New Time Server Thread started...");
			} catch(IOException e) {
				System.out.println("Can't start server thread!!");
				e.printStackTrace();
				try {
					client.close();
				} catch(IOException i) {}
			}
		}		
		try {		
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			// 서버는 24시간 기동해야 하므로 반복문에 true로 처리 하였음
			while(true) {
				// 클라이언트측에 현재 시간 정보를 쓰는 메소드 호출임
				oos.writeObject(getTimeStr());
				try {
					// 밀리세크 단위 이므로 1000이 1초를 의미함
					sleep(1000);
				} catch(InterruptedException i) {
					System.out.println("다른 스레드가 인터셉트 해오면 잡히게 됨. 뭐래!!!");
				}
			}
		} catch (IOException e) {
			// 아래 메소드 호출하면 stack메모리에 쌓인 에러와 관련된 메시지를 라인번호와 함께 history를 출력해줌
			// 디버깅 할때 자주 사용하는 메소드임. 꼬오옥... 기억하자
			e.printStackTrace();
		} finally {// 예외가 발생하더라도 무조건 실행해야 하는 부분이 있을 때 사용함.
			System.out.println("\nClient disconnected...\n");
			try {
				// 여기서는 뭔가 예외 상황이 발생하면 클라이언트측의 소켓 정보를 가진 객체를 닫아줌
				socket.close();
			} catch(IOException e) {}
		}
	}
// run() 종료

	// 현재 시간 정보를 생산하는 메소드 구현하기
	private String getTimeStr() {
		// 카렌더 클래스를 이용하면 현재 시간 정보를 가져오는 메소드 호출 가능함.
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		// 시간 분 초가 한 자리 일 때 두자리로 만들고 0을 붙이기 위한 삼항연산자 사용
		return (hour < 10 ? "0" + hour : "" + hour) + ":" +
				(min < 10 ? "0" + min : "" + min)  +	":" +
				(sec < 10 ? "0" + sec : "" + sec) ;
		
	}
	// getTimeStr() 종료

// main() 시작
	public static void main(String args[]) {
		TimeServerVer2 ts = new TimeServerVer2();
		ts.start();
	}
// main() 종료
}

