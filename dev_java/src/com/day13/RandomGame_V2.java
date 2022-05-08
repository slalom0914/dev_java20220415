package com.day13;

import java.util.Random;
import java.util.Scanner;

public class RandomGame_V2 {
	// 컴터가 채번하는 일을 전담하는 메소드 구현
	public void randomNumber() {
		
	}
	//사용자가 입력하는 값을 받아서 판정하는 메소드에 전달하기 구현
	public void userInput() {
		
	}
	public void gameStart() {
		// 게임 유저들에게 회차정보를 제공하세요 - 요구사항
		// 회차를 카운트 해야 하는 경우는 언제 일까요?
		// 정답을 맞추었을 때 - 종료
		// 높여라 라는 힌트를 주거나 낮춰라 라는 힌트를 준다면 기회를 한 번 잃어버린다.
		int cnt = 5;
        Random r = new Random();
        int dap = r.nextInt(10);//0이상10미만사이의 정수를 리턴해 준다.
        Scanner scan = new Scanner(System.in);
        System.out.println("0부터 9까지의 숫자를 입력하시오.");
        String str = null;
        // 만일 i가 6이라면 for문 안에 실행문이 진행될 수  있을까?
        for(int i=1;i<6;i++){
        	str = scan.next();
        	// 만약에 i값이 5이면 진행되어야 하는가?
        	// 만약에 i값이 6이면 어디로 가야하지?
        	// if if는 매번 조건을 따지지만 else if문을 사용하면 첫번째 조건이
        	// 만족되었을 경우 아래 조건은 따지지 않고 if문 블록을 탈출한다.
            if(i==5) {
            	System.out.println("더 이상 기회는 없습니다.");
            	break;
            }
            if(Integer.parseInt(str)==dap){
                System.out.println("마따~");
                break;
            }
            else if(Integer.parseInt(str) > dap){// 너무 큰 숫자를 적었네요. 낮춰라 -힌트문 제공한다. 요구사항이다. 요구사항 정의서 작성
                cnt--;
            	System.out.println("나차라~");
            }
            else if(Integer.parseInt(str) < dap){
            	cnt--;
                System.out.println("노피라~");
            }

            // 그렇다면 과연 언제 for문을 탈출할 수 있는가?
            // 5번 기회 중에서 3번째 정답을 맞추면 나간다. 
            // 5번을 초과해서 사용자가 입력을 할 수 있나요?
        }//while ended		
        System.out.println("while문 탈출하면 여기가 출력된다.");
	}///////////////// [[[ end of gameStart ]]] //////////////////
    public static void main(String[] args){
    	//메소드 호출시 구현된 메소드 앞에 static이 있으면 인스턴스화 없이 클래스 타입.메소드명() 호출가능하다.
    	RandomGame_V1 rv = new RandomGame_V1();
    	rv.gameStart();
    }/////////////////// [[[ end of main ]]] /////////////////////
}


