package com.day18;

import java.util.StringTokenizer;

public class TalkClientThread extends Thread {
	TalkClient tc = null;
	public TalkClientThread(TalkClient tc) {
		this.tc = tc;
	}
	@Override
	public void run() {
		boolean isStop = false;
		while(!isStop) {
			try {
				String msg = "";
				msg = (String)tc.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;
				if(msg !=null) {
					st = new StringTokenizer(msg, "#");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
					case 100:{
						String nickName = st.nextToken();
						tc.jta_display.append(nickName+"님이 입장하였습니다.\n");
					} 
					// 200#토마토#스터디할거야?
					case 200:{
						String nickName = st.nextToken();
						String message = st.nextToken();
						tc.jta_display.append("["+nickName+"]"+message+"\n");
					}break;
				}///// end of switch
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}// end of run()
}
