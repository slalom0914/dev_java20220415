package com.day18;

import java.util.StringTokenizer;

public class MessageParser {

	public static void main(String[] args) {
		String msg = "200#tomato#banana#오늘 스터디할까?";// tomato님이 입장하였습니다.
		StringTokenizer st = new StringTokenizer(msg, "#");
		while(st.hasMoreTokens()) {
			String imsi = st.nextToken();
			System.out.println(imsi);
		}
	}

}
