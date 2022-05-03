package com.day10;
class Super2{
	public float getNum() {
		return 3.0f;
	}
}
public class Sub2 extends Super2{
	@Override
	public float getNum() {
		return 4.0f;
	}	
	// 왜 되는 건가요? - 메소드 오버로딩의 조건을 수렴하니까
	public double getNum(int i) {
		return 4.0f;
	}	
	public double getNum(double d) {
		return 4.0f;
	}	
	public double getNum(float f) {
		return 4.0f;
	}	
	public double getNum(float f, String name) {
		return 4.0f;
	}	
}
