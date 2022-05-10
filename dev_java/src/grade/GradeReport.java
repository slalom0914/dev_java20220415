package grade;

public class  GradeReport {



	public static void main(String[] args) {
		int score[][] = { 
				{ 100, 30, 50 },
				{ 85, 90, 80 }, 
				{ 80, 35, 45 }, 
				{ 90, 60, 65 }, 
				{ 100, 100, 100} 
				};
		
		Grade_Print g = new Grade_Print(new Calculate(score));
		g.grade_Print(); // 모두 출력
		// g.grade_Print(g.total);  총점만 출력
		// g.grade_Print(g.avg);   평균만 출력
		// g.grade_Print(g.rank);  순위만 출력
		
		}	
	}

