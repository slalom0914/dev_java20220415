package grade;

import java.util.Random;

public class Jumsu {
	Random r = new Random();
	double total; 			  // 총점 변수
	double avg; 			  // 평균 점수
	int grade; 				  // 석차 변수
	int rdjumsu; 			  // 랜덤점수 담는 변수
	int jumsu[] = new int[5]; // 배열에 담은 변수 개수(?)
	int i;

	public Jumsu() {
		for (i = 0; i < 5; i++) { 									// 5번 반복
			rdjumsu = r.nextInt(101); 								// 랜덤점수 발생
			System.out.println("랜덤정수 발생 : " + rdjumsu); 		    // 랜덤정수 출력
			jumsu[i] = rdjumsu; 									// 각 배열위치에 랜덤점수를 배치
			System.out.println(i + "번 째 배열 : " + jumsu[i] + "\n");	// i번째 배열의 랜덤점수 출력
		}/////////////////////[end of for]
	}/////////////////////////[end of Jumsu construtor] 

	public void jumsu_1() {
		i = 0;											 // i == 5 → i = 0 초기화
		while (i < 5) {									 // while 반복문
			total = total + jumsu[i]; 					 // 총점구하는 식	
			System.out.println(i + " 번째 더하기" + total); // n번째 누적 수 출력
			i++;                                      
		}/////////////////////[end of while]
		System.out.println("총점 : " + total);   	// 총점 출력
		avg = total / 5.0;					    // 평균
		System.out.println("평균 : " + avg);		// 평균점수 출력
	}/////////////////////////[end of jumsu_1 method]

	public static void main(String[] args) {
		Jumsu js = new Jumsu();					// Jumsu클래스 인스턴스화와 동시에 생성자 실행(?)
		js.jumsu_1();							// Jumsu클래스의 jumsu_1메소드 호출
	}/////////////////////////[end of main]
}/////////////////////////////[end of Jumsu class]
