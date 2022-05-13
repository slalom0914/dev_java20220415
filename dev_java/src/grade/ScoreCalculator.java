package grade;

import java.util.Scanner;


/**추상클래스로 성적계산기 구현해보기**/

public abstract class ScoreCalculator {
	Scanner in = new Scanner(System.in);
	
	int student;
	int subject;
	int[][] score = new int[student][subject];
	
// 생성자 
	ScoreCalculator ( ) {
		
		System.out.println("============성적 계산기 시작=============");
		System.out.println("학생 수를 입력하세요 : ");
		System.out.println("과목 수를 입력하세요 : ");
		System.out.println("\n");
		
		Scanner in = new Scanner(System.in);
		
		// 전역변수 
		this.student = in.nextInt();
		this.subject = in.nextInt();
		
		this.score = new int[student][subject];
		
	// 성적 입력받기 
		for(int i = 0; i < student; i++) {
			for(int j = 0; j < subject; j ++) {
				score[i][j] = in.nextInt();
			}
		}		
	}
	
	
	// 추상 메소드 **총점(과목 or 학생)**
		public abstract void addUpScore (); 
			
	// 추상 메소드 **평균(과목 or 학생)**
		public abstract void avgScore ();
				
	// 추상 메소드
		public abstract void rankingScore ();
		
}
