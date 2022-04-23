package com.week1;

public class ReturnType_2 {
	String name;
	void login(String mem_id, String mem_pw) {
		name = "이순신";
	}
	public static void main(String[] args) {
		ReturnType_2 rt = new ReturnType_2();
		rt.login("tomato", "123");
		System.out.println(rt.name+"님 환영합니다.");
	}

}
