package com.day5;

public class SungJuk {
	int kor=90;
	int eng=95;
	int math=60;
	int total() {
		int hap = 0;
		hap = kor+eng+math;//245
		return hap;
	}
	/*************************************************
	 * 평균을 구하는 메소드 구현
	 * @param hap - 세과목에 대한 총점을 복사해온다
	 * @return double - 총점을 국어,수학,영어 세과목으로 나눈다
	 * double/double => double
	 ************************************************/
	double average(int hap) {
		double avg = hap/3.0;
		return avg;
	}
	public static void main(String[] args) {
		// 참조형 변수 이다. sj는 참조형 변수로 호출하면 주소번지가 출력됨
		// 언제 사용하지? 클래스 안에 선언된 변수나 메소드를 누릴때 사용함
		SungJuk sj = new SungJuk();
		int hap = sj.total();
		System.out.println("총점은 "+hap);
		//insert here - 평균은 너가 해보세요
		double avg = sj.average(hap); 
		System.out.println("평균은 "+ avg);
		// insert here - 굳이 업무담당자가 화면에 과목명을 출력해 달고 한다.
		// 어떡하지? 
		//non-static의 변수명을 static영역에서 사용하려면 인스턴스화를 한다
		System.out.println("국어:"+sj.kor
				        +", 영어:"+sj.eng
				        +", 수학:"+sj.math);
		System.out.println("국어:"+sj.kor);
		System.out.println("영어:"+sj.eng);
		System.out.println("수학:"+sj.math);
		System.out.print("국어:"+sj.kor);
		System.out.print("영어:"+sj.eng);
		System.out.print("수학:"+sj.math);
	}

}
