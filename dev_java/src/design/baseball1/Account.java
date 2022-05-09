package design.baseball1;

public class Account {
	NanSu ns = null;
	int my[] = null;
	public Account() {
		ns = new NanSu();
		ns.nanSu();
		System.out.println("컴터가 채번한 숫자 : "+ns.com[0]+""+ns.com[1]+""+ns.com[2]);	
		my = new int[3];
	}
	//전광판에 출력될 메시지를 작성하는 메소드 선언
	public String call(String input){
		//스트라이크를 카운트할 변수
		int strike = 0;
		//볼을 카운트할 변수
		int ball = 0;		
		int temp = 0;
		//반드시 세자리 숫자 이어야 한다.
		if(input.length()!=3){
			return "세자리 숫자만 입력하세요!!!";
		}
		temp = Integer.parseInt(input);
		my[0] = temp/100;//백자리를 받는다.
		my[1] = (temp%100)/10;//십자리를 받는다.
		my[2] = temp%10;
		for(int i=0;i<ns.com.length;i++){
			for(int j=0;j<my.length;j++){
				//같은 숫자가 존재하는 경우(볼확보)
				//컴퓨터가 채번한 숫자가 있는지 비교
				if(ns.com[i] == my[j]){
					//자리수까지도 일치하는 경우(스트라이크확보)
					//그 숫자가 존재하는 배열의 인덱스값을 비교
					if(i==j){
						strike++;
					}else{
						ball++;
					}
				}//  end of if          //////////////// 
			}//////  end of inner for   ////////////////
		}//////////  end of outter for  ////////////////
		if(strike == 3) return "정답입니다.";
		return strike+"스트라이크" +ball+"볼";
	}/////////////  end of call ////////////////////////	
	public static void main(String[] args) {
		Account ac = new Account();
		String result = null;
		result = ac.call("256");
		System.out.println(result);
	}

}
