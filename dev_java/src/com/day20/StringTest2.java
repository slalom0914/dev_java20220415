package com.day20;

import java.util.StringTokenizer;

public class StringTest2 {

	public static void main(String[] args) {
		String insa = "Have,a,good,time!!!";
		StringTokenizer st = new StringTokenizer(insa,",");
		int count = st.countTokens();
		String words[] = new String[count];
		int i = 0;
		while(st.hasMoreTokens()) {
			words[i] = st.nextToken();
			i++;
		}
		for(int j=0;j<words.length;j++) {
			System.out.println(words[j]);
		}
		for(int j=words.length-1;j>=0;j--) {
			System.out.println(words[j]);
		}
	}

}
