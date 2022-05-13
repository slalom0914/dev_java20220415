package com.day17;

public class TwoArray_1 {
// 메모리 구조는 무조건 1층 구조이다.2층이나 3층은 아예 없다.
// 마치 2층이나 3층이 있는것 처럼 처리하는 것이다.
// 다차원 배열이 가능하다
// jumsus[0] 호출하면 값이 출력되지만 2차배열에서는 1차 배열의 주소번지 이다.
	public static void main(String[] args) {
		//UI - 테이블 구조
		// 오라클서버 설치 - 테이블 조회 - 테이블 구성요소(컬럼+로우)
		int jumsus[][] = new int[3][2];
		jumsus[0] = new int[2];
		jumsus[0][0] = 0;
		jumsus[0][1] = 0;
		jumsus[1] = new int[2];
		jumsus[1][0] = 0;
		jumsus[1][1] = 1;
		jumsus[2] = new int[2];
		for(int i=0;i<jumsus.length;i++) {
			for(int j=0;j<jumsus[i].length;j++) {
				System.out.println("jumsu["+i+"]["+j+"]="+jumsus[i][j]);
			}
		}
	}

}
