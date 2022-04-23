package com.week1;

public class ReturnType_1 {
	String login(String mem_id, String mem_pw) {
		String name = "이순신";
		return name;
	}
	public static void main(String[] args) {
		ReturnType_1 rt = new ReturnType_1();
		String name = rt.login("tomato", "123");
		System.out.println(name+"님 환영합니다.");
	}

}
