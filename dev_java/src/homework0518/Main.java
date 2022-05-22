package homework0518;

public class Main {

	public static void main(String[] args) {

// 컴퓨터의 처음 모니터 사이즈 출력 
		Computer computer = new Computer();
		int initMonitor = computer.initSize;
		System.out.println("초기 모니터 사이즈 : " + initMonitor);
		System.out.println("\n========================================\n");

// 모니터 사이즈를 바꾸고 싶다. 
		Monitor monitor = new Monitor();

		// setMonitor 참조변수 생성 후 모니터 사이즈를 36으로 변경
		int setSize = monitor.biggerMonitor();
		System.out.println("모니터 사이즈 (setMonitor.initMonitor(36)) : " + setSize);

		// setMonitor 참조변수 생성 후 모니터 사이즈를 24로 변경
		setSize = monitor.smallerMonitor();
		System.out.println("모니터 사이즈 (setMonitor.initMonitor(24)) : " + setSize);
	}

}
