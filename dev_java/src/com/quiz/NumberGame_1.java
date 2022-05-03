package com.quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NumberGame_1 {
	public static void main(String[] args) {
	new GameStart1();
	}
}

class GameStart1 extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L; // Serializable을 구현한 클래스의 경우 임의의 serialVersionUID 정적인 필드를 정의해 주는 것이 좋다
	JButton btn;
	JTextField answer; // 사용자 입력 값
	JLabel question; // 게임 질문
	JLabel label; // 기회UI
	int chance; // 기회 count
	int num; // 0~9난수 저장
	GameStart1(){
		super("숫자 맞추기 게임-Ver1.1"); // 부모 생성자는 첫줄
		this.num = (int)(Math.random()*10); 
		this.chance = 5;
		System.out.println("게임을 시작합니다. 결과는 Console창에서 확인 해 주세요");
		set_Display();
	}
		// 화면설정 메서드 
	public void set_Display(){
		// 질문창 생성
		question = new JLabel("Enter a number between 0 and 9");
		question.setSize(200,30);
		question.setLocation(55,5);
		add(question);
		
		// 입력창 생성
		answer = new JTextField();
		answer.addActionListener(this);
		answer.setSize(40,20);
		answer.setLocation(120, 50);
		add(answer);
		
		// 버튼 생성
		btn = new JButton("입력");
		btn.addActionListener(this);
		btn.setBounds(90, 180, 110, 30);
		getContentPane().add(btn);
		
		// 기회UI 생성
		label = new JLabel();
		label.setBounds(100,220,150,30);
		label.setText("기회 " + chance + "번 남음");
		getContentPane().add(label); 
		
		// 프레임 설정
		getContentPane().setLayout(null); // 콤포넌트의 크기와 위치를 일일이 다 지정 해 줘야한다. 프레임의 절대위치 사용
		setLocation(700,300); // 프레임의 (x,y)위치 조정
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료하면 JVM에서 완전히 지움. 메모리 관리를 위해 꼭 써주기. 정상 종료
		setVisible(true);
	} // end of set_Display
	
	public void gameAccount() {
		try {
		int input = Integer.parseInt(answer.getText()); // 입력값 int로 변환하여 저장
		if(chance <= 0) {
			System.out.println("틀렸습니다. 기회가 없어서 프로그램을 종료합니다");
			System.exit(0);
		}else if(input == num) {
			System.out.print("정답입니다.\n프로그램을 종료합니다.");
			System.exit(0);
		}else if(input > num) {
			--chance;
			if(chance <= 0) {
				System.out.print("틀렸습니다. 정답은 " + num + "입니다. \n프로그램을 종료합니다.");
				
				System.exit(0);
				}
			label.setText("기회 " + chance + "번 남음");
			System.out.println("틀렸습니다. 더 작은 수를 입력하세요.");
			answer.setText("");
		}else if(input< num) {
			--chance;
			if(chance <= 0) {
				System.out.println("틀렸습니다. 정답은 " + num + "입니다. \n프로그램을 종료합니다.");
				System.exit(0);
				}
			label.setText("기회 " + chance + "번 남음");
			System.out.println("틀렸습니다. 더 큰 수를 입력하세요");
			answer.setText("");
			}
		}catch(NumberFormatException n) { // 숫자 외의 값 입력했을 때 발생하는 예외 처리. NumberFormatException은 숫자 형식 오류
			System.out.println("숫자만 입력해 주세요");
			answer.setText("");			
		}		
	}
	
	// 버튼 이벤트 처리 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == answer || obj == btn) {
			gameAccount();
		}
		
	}
} // end of GameStart class
