package com.week1;

public class ReturnType_1 {
	String login(String mem_id, String mem_pw) {
		String db_id = "tomato";
		String db_pw = "124";
		if(mem_id.equals(db_id)) {
			System.out.println("아이디가 존재합니다.");
		}else {
			
		}
		String name = "이순신";
		return name;
	}
	public static void main(String[] args) {
		ReturnType_1 rt = new ReturnType_1();
		String name = rt.login("tomato", "123");
		System.out.println(name+"님 환영합니다.");
	}

}
