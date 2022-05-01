package com.day7;

public class DeptVOSimulation {

	public static void main(String[] args) {
		DeptVO dvo = new DeptVO();
		// 전역변수에 접근제한자가 private이면 외부에서 접근불가함
		// 왜 접근제한자를 private으로 했나?
		// 하나의 클래스로 100명의 정보를 구분할 수 있어야 한다
		dvo.setDeptno(10);
		System.out.println(dvo.getDeptno());
		dvo.setDname("개발1팀");
		System.out.println(dvo.getDname());
		dvo.setLoc("서귀포");
		System.out.println(dvo.getLoc());

	}

}
