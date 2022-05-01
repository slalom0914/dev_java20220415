package com.day9;
// 변수가 몇 개 필요하니? - 3개
// 변수 위치는?
public class Shuffle_5 {
	int i=3;
	int j=6;
	public boolean methodA() {
		boolean isOk = false;
		i = j;// 3->6
		j = i;
		System.out.println(i+", "+j);
		if(i!=3 && j!=6) isOk = true;
		return isOk;//셔플이 성공하면 true, 실패하면 false
	}
	public void methodB() {}
	public static void main(String[] args) {
		Shuffle_5 s4 = new Shuffle_5();
		boolean isOk = s4.methodA();
		if(isOk) {
			System.out.println("참 잘했어요^^");
		}else {
			System.out.println("다시 한 번 생각해보세요.");			
		}
		s4.methodB();
	}

}
