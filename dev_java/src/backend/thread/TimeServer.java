package backend.thread;

//TimeServer.java: 1초간격으로 현재의 시간 문자열을 접속한 클라이언트에게 전송하는 
//프로그램
import java.net.*;
import java.io.*;
import java.util.*;
// TimeServer is a Thread 관계가 성립하여 상속으로 처리함
// 어떤 클래스가 스레드가 된다면 run메소드를 오버라이딩 할 수 있고 
// 어떤 일을 계속해서 1초 동안 멈추었다가 실행하고  또 1초 동안 멈춤이었다가 실행되게 하는
// sleep이라는 메소드를 호출 할 수 있음.
public class TimeServer extends Thread {
	// 클라이언트가 서버에 접속해 오면 클라이언트의 소켓 정보를 담을 소켓 선언임
	// null인 상태로 있다가 클라이언트측에서 인스턴스화 된 정보를 받아서 담게 됨
	private Socket socket;
	public TimeServer(Socket s) {
		this.socket = s;
	}
	// 부모 클래스 여기서는 Thread에 선언되어 있는 메소드를 오버라이딩 한 것임
	// 이벤트 처리시 사용되었던 actionPerformed 메소드 처럼 콜백메소드 임.
	@Override
	public void run() {
		System.out.println("run call....");
		// 네트워크를 통해 통신을 하게 되므로 항상 예외상황이 발생할 수 있음.
		// 와이파이가 불안정 하거나 인터넷이 끊기는 현상이 일어날 수 있음.
		try {		
			// OutputStream은 말할(쓰기) 때 사용하는 클래스임
			// 타임서버에 접속해온 클라이언트에게 서버 컴터 기준의 시간정보를 계산해서
			// 타임서버에 접속해온 클라이언트 소켓을 사용하여 생성한 ObjectOutputStream을 통해서 
			// 서버측에서 생성된 시간 정보를 쓰기 해줌
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
		// 클라이언트측에 포트 번호 열어주기 - 반드시 서버측에서 정해야 함
		// 포트 번호는 집으로 치면 대문에 해당하는 중요한 정보임
		// 1번 부터 6557X번호 사이에 있는 숫자를 사용할 수 있지만 보통 운영체제가 1~1023번 까지는 사용하므로 
		// 이 구간 번호는 제외하고 사용해야 함. 반드시 지켜야 함
		// 이미 할당된 번호를 사용하면 에러 발생함
		int port = 2008;
		// 언제 접속을 시도할지 예측할 수 없는 클라이언트측을 위해 서버측에서만 제공함
		ServerSocket server = null;
		// ServerSocket에 접속 해온 클라이언트측 정보를 받을 객체 선언
		// 실제 클라이언트측에 시간 정보를 제공하는데 사용되는 클래스 임.
		// ServerSocket을 통해 접속해온 클라이언트 정보를 accept()통해 받아옴.
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
		
		while(true) {
			try {
				// 클라이언트측에서 new Socket("서버아이피",포트번호); 실행될 때 까지 아래는 진행안됨
				// 여기서 중지 상태로 기다림..
				client = server.accept();
				System.out.println("New Client connected...");
				// 클라이언트측에서 소켓이 생성되면 전변으로 선언한 Socket에 주소번지 넘김
				TimeServer tServer = new TimeServer(client);
				// run메소드를 직접 호출하는 것이 아니라 start를 호출하면 JVM이 스레드 순번에 따라
				// run메소드를 호출하게 됨. 스레드 컨벤션임
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
	}
// main() 종료
}

