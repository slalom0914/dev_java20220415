package homework0515;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("10개의 숫자가 궁금하십니까?");
		String yes = sc.nextLine();
		System.out.println(yes);
		if("y".equals(yes)) {
			System.out.println("지금 바로 공개합니다");
			Random rd = new Random();
			for (int i = 0; i < 10; i++) {
				int ird = rd.nextInt(21) - 10;
				System.out.println(ird); 
			}			
		}
		else {
			System.out.println("비공개를 원하는 군요!!!");
		}
	}////////// end of main
}
