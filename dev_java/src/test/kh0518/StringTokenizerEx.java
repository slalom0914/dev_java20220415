package test.kh0518;

import java.util.StringTokenizer;

public class StringTokenizerEx {

	public static void main(String[] args) {
		String msg = "200#tomato#오늘 스터디할까?";
		StringTokenizer st = new StringTokenizer(msg,"#");
		int cnt = st.countTokens();
		System.out.println("countTokens : "+cnt);
		while(st.hasMoreTokens()) {
			String temp = st.nextToken();
			System.out.println(temp);
		}
	}

}
