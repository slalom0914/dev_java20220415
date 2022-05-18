package com.day20;

public class ExceptionTest {

	public static void main(String[] args) {
		int i = 5;
		int j = 0;
		try {
			int x = i/j;		
			// 다중문 처리시 상위 클래스 항상 뒤에 온다.
		} catch (ArithmeticException ae) {
			System.out.println(ae.toString());
		} catch (RuntimeException re) {
			System.out.println(re.toString());			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}////////////end of main
}
