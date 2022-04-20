package com.method;

public class MemberVO {
	private String  name   = null; // 이름을 담아요
	private int     age    = 0;    // 나이를 기억하고 싶어
	private boolean gender = false;// 당신의 성별은 무엇입니까?(true:남, false:여)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
}
