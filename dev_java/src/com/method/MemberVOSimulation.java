package com.method;

public class MemberVOSimulation {

	public static void main(String[] args) {
		MemberVO mVO = new MemberVO();
		// MemberVO의 변수 name의 접근제한자가 private이므로
		// name 변수에 직접 접근이 불가함
		// 그럼 어떡하지? - setter메소드를 사용하면 접근이 가능함
		//mVO.name="강감찬";
		mVO.setName("이순신");
		mVO.setAge(30);
		mVO.setGender(true);
		mVO.setGender(false);
		if(mVO.isGender()) {
			System.out.println("당신은 남자");
		}
		else {
			System.out.println("당신은 여자");			
		}
		System.out.println("당신의 이름은 "+mVO.getName()+" 입니다.");
		System.out.println("당신의 나이는 "+mVO.getAge()+" 입니다.");
	}

}
