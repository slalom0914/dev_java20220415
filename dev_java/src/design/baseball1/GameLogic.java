package design.baseball1;

public class GameLogic {
	int my[] = new int[3];
	NanSu ns = new NanSu();
	public GameLogic() {
		System.out.println("GameLogic 디폴트 생성자 호출 성공");
		ns.nanSu();
		// 컴터가 채번한 값 출력해 보기
		System.out.println("컴터가 채번한 숫자 : "+ns.com[0]+""+ns.com[1]+""+ns.com[2]);	
	}
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
					System.out.println("내가 입력한 숫자가 컴터가 채번한 숫자에 있을 때 실행됨.");
					//자리수까지도 일치하는 경우(스트라이크확보)
					//그 숫자가 존재하는 배열의 인덱스값을 비교
					if(i==j){
						System.out.println("스트라이크 확정 - 내가 입력한 숫자가 컴터가 가진 숫자와 자리수까지 같을 때");
						strike++;
					}else{
						System.out.println("볼 확정 - 내가 입력한 숫자가 컴터가 가진 숫자와 자리수는 다를 때");
						ball++;
					}
				}//  end of if          //////////////// 
			}//////  end of inner for   ////////////////
		}//////////  end of outter for  ////////////////
		if(strike == 3) return "정답입니다.";
		return strike+"스트라이크" +ball+"볼";
	}/////////////  end of call ////////////////////////	
	public static void main(String args[]) {
		GameLogic gl = new GameLogic();
		System.out.println("내가 입력한 숫자 : 259 ===> 판정결과 : "+gl.call("259"));
	}
}
