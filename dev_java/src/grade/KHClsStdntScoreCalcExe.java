package grade;

public class KHClsStdntScoreCalcExe {

	public static void main(String[] args) {
		
		KHClassStudent class9To15 = new KHClassStudent();
		System.out.println("**********성적 총합***********\n");
		class9To15.addUpScore();
		
		System.out.println("\n**********성적 평균***********\n");
		class9To15.avgScore();
		
		System.out.println("\n**********석   차***********\n");
		class9To15.rankingScore();
	}

}
