package com.dice;

import java.util.Scanner;
import java.util.Random;
/////////////////////////////////////////////////// Random Dice 1 ///////////////////////////////////////////////////
/////////////////////////////////// 게임 시작 묻기 - 숫자 입력 후 성공 여부 묻기 - 게임 종료 ////////////////////////////////////
public class RandomDice3 {

	public static void main(String[] args) {
		// 난수를 발생하는 메소드를 제공하는 클래스 인스턴스화 하기
		Random ran = new Random();
		// 0부터 9까지 정수 채번하기
		int answer = ran.nextInt(10);
		System.out.println("컴터가 채번한 값 출력 : "+answer);
		// 사용자가 콘솔에 입력하는 값 받아오기
		Scanner scan = new Scanner(System.in);
		// 사용자가 선택하는 메뉴 담을 변수 선언
		String str = null;
		
		System.out.println("==========Random Dice==========");
		System.out.println("게임을 시작하시겠습니까? 1.Yes 2.No");
		
		while((str=scan.next()) !=null) {
			if(str.equals("1")) {
				System.out.println("게임을 시작합니다.");
				break;
			} else if(str.equals("2")) {
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			}
		}
		System.out.println("0부터 9까지의 숫자를 입력하세요.");
		// 사용자가 입력한 0~9사이의 문자 담을 변수 선언
		String imsi = null;
		// 사용자가 정답을 맞추었는지 유무를 담을 변수 선언
		boolean isOk = false;// 맞추면 true 저장
		while((imsi=scan.next()) !=null) {
			int input = Integer.parseInt(imsi);
			if(input == answer) {
				// 정답을 맞춘 상황이므로 isOk변수에 true를 재정의
				isOk =true;
				System.out.println("정답입니다.");
				System.out.println("게임을 종료합니다.");
				break;
			} else if(input < answer) {
				System.out.println("더 높은 숫자입니다.");
			} else if(input > answer) {
				System.out.println("더 낮은 숫자입니다.");
			} 
		}//////////// end of while 
		System.out.println("while문 탈출함");
	}//////////////// end of main
}//////////////////// end of class
