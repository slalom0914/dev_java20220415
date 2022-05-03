package com.day10;

public class X5 {

	public static void main(String[] args) {
		String s1 = new String("이순신");
		String s2 = new String("이순신");
		System.out.println(s1+","+s2);
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
