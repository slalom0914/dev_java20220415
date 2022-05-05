package test.kh0503;
// 더 큰타입은 더 작은 타입에 대입연산자를 통해서 재정의 할 수  없다.
// 대입(=) 연산자를 기준으로 오른쪽이 왼쪽보다 큰 타입이 오면 폭망이다. 

public class Exam1 {

	public static void main(String[] args) {
		int i = 5;//지변
		double d = 1.5;
		i = (int)d;
		// 위와 같이 강제 형전환을 시키면 0.5 는 담을 수가 없다.
		System.out.println(i);// 5
		boolean isOk=false;
		if(isOk) {
			float f = 1.5f;
			// 조건을 만족하지 않으면 단 한번도 실행기회는 없다.
			//insert here - 실행문
		}else {
			
		}
		//System.out.println(f);
		Exam1 e1 = new Exam1();
		//인스턴스변수.변수명 불가하다.
		System.out.println(e1.i);
	}

}
