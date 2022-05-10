package com.week4;

public class MaxSearch {
	/**************************************************************************
	 * 파라미터로 받은 점수중에 가장 최고점수를 찾아주는 메소드 구현
	 * @param oracle - 배열로 점수를 받습니다.
	 * @return high - 최대값을 담아 줍니다.
	 *************************************************************************/
	int max(int[] oracle){
		int high = 0;
		high = oracle[0];
		for(int i=1;i<oracle.length;i++){//배열의 크기보다 1작게
			if(high < oracle[i]){
				high = oracle[i];
			}
		}
		return high;
	}
	/**************************************************************************
	 * 파라미터로 받은 점수중에 가장 최저점수를 찾아주는 메소드 구현
	 * @param oracle - 배열로 점수를 받습니다.
	 * @return high - 최소값을 담아 줍니다.
	 *************************************************************************/	
	int min(int[] oracle){
		int low = 0;
		low = oracle[0];
		for(int i=1;i<oracle.length;i++){//배열의 크기보다 1작게
			if(low > oracle[i]){
				low = oracle[i];
			}
		}		
		return low;
	}
	public static void main(String[] args) {
		int max = 0;
		int min = 0;
		int oracle[] = {70,85,90,70,65};
		max = oracle[0];
		min = oracle[0];
		for(int i=1;i<oracle.length;i++){//배열의 크기보다 1작게
			if(max < oracle[i]){
				max = oracle[i];
			}
			if(min > oracle[i]){
				min = oracle[i];
			}
		}
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
	}

}
