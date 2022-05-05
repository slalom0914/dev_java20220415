package test.kh0503;

public class Exam3 {
	
	public static void main(String[] args) {
		//원시형 타입은 부르면 값이 나온다.
		// 원시형은 하나만 선언할 수 있다.
		//참조형 타입은 부르면 주소번지가 출력된다.
		boolean isFail = false;
		Exam3 e3 = new Exam3();
		// e3은 참조형 변수라고 한다.
		// 참조형 변수에는 여러개의 변수가 있을 수 있다.
		// 클래스 안에는 여러개의 변수를 선언할 수 있다.
		System.out.println(e3);// @45cba234주서번지출력됨
		// 디폴트 생성자가 호출된다.
		// uVO를 인스턴스(참조형)변수라 한다.
		// 디폴트 생성자를 호출했을 때는 
		// mem_id = null, mem_pw = null, birth = null초기화
		UserVO uVO = new UserVO();
		// mem_id = "banana", mem_pw = "156", birth = "1999-12-25"초기화
		//uVO = new UserVO("banana","156","1999-12-25");
		// 왜냐하면 접근제한자 private이므로 클래스 외부에서는 접근이 불가함.
		System.out.println(uVO.getMem_id());
		System.out.println(uVO.getMem_pw());
		System.out.println(uVO.getBirth());
	}

}
