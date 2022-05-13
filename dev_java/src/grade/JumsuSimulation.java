package grade;

public class JumsuSimulation {
	public static void main(String[] args) {
		int total = 0;
		//Jumsu_2 js = new Jumsu_2(i);					// Jumsu클래스 인스턴스화와 동시에 생성자 실행(?)
		Jumsu_3 js = new Jumsu_3();					// Jumsu클래스 인스턴스화와 동시에 생성자 실행(?)
		total = js.tot();
		js.avg(total);
	}
}
