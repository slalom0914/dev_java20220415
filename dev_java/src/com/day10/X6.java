package com.day10;

public class X6 {

	public static void main(String[] args) {
		// 아래 처럼 new를 사용하면 아무리 같은 문자열이라도
		// 다른 주소번지를 할당하고 새로운 객체를 생성함
		String s1 = new String("이순신");
		String s2 = new String("이순신");
		// new 사용하지 않고 문자열 객체를 생성하면
		// 기존에 같은 문자열 값을 갖고 있는 객체가 있는지 찾아보고
		// 그 주소번지를 복사하여 갖고 있게 됨
		String s3 = "이순신";
		String s4 =  s3;
		System.out.println(s3+","+s4);
		if(s3.equals(s4)) {
			System.out.println("s3과 s4가 Equal");
		}else {
			System.out.println("s3과 s4가 Not Equal");			
		}
		if(s3 == s4) {
			System.out.println("주소번지가 같다");			
		}else if(s3!=s4) {
			System.out.println("주소번지가 다르다");						
		}
		System.out.println("==========================");
		if(s1.equals(s2)) {
			System.out.println("Equal");
		}else {
			System.out.println("Not Equal");			
		}
		if(s1 == s2) {
			System.out.println("주소번지가 같다");			
		}else if(s1!=s2) {
			System.out.println("주소번지가 다르다");						
		}
	}

}
