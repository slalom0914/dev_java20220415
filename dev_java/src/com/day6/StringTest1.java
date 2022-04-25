package com.day6;

import javax.swing.JButton;

public class StringTest1 {

	public static void main(String[] args) {
		StringTest1 st1 = new StringTest1();
		//자바에서 제공되는 클래스 입니다.
		//따라서 개발자의 의도와 상관없이 자기가(JVM) 생각하고 있는
		//값을 출력하는 경우도 있습니다. 그래서 결과가 다르게 출력됨
		//일관성이 없이 말이 바뀐다
		JButton jbtn = new JButton("북쪽");
		// 이것은 자바가상머신에서 제공되는 클래스가 아님
		System.out.println("StringTest1 ==> "+st1);//@21123afc
		System.out.println("StringTest1 ==> "+st1.toString());//@21123afc
		//참조형 변수 이다.
		String s = new String("좋은 아침입니다.");
		String s1 = new String("좋은 아침입니다.");
		System.out.println("String ==> " + s);//@4532aef
		// = 대입연산자
		// == 같다 -> 다르다 boolean false, 
		//  주소번지 s와 주소번지 s1이 같니? true 이거나 false
		 if(s==s1) {
			 System.out.println("같다");
		 }
		 else {
			 System.out.println("다르다");
			 
		 }
		 if(s.equals(s1)) {
			 System.out.println("같다");
		 }
		 else {
			 System.out.println("다르다");
			 
		 }
				
	}

}
