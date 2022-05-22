package homework0518;

public class Monitor {
	Computer setMonitor = null;

	// 객체를 생성하는 메소드
	Computer getInstance() {
		if (setMonitor == null) {
			setMonitor = new Computer();
		}
		return setMonitor; // Computer 클래스 참조하는 setMonitor 생성
	}

	int biggerMonitor() {
		// setMonitor참조변수로 모니터를 24로 변경해라.
		return getInstance().initMonitor(36);
	}

	//
	int smallerMonitor() {
		return getInstance().initMonitor(24);
	}

}
