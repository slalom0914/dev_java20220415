package grade;

//세자리수의 백자리,십의자리,일의자리 각각 추출하여 출력하기
public class UserInput {
	int my[] = new int[3]; //3개의 배열 생성하여 my배열에 담기.

	public void inputValue(String user) {
		int temp = Integer.parseInt(user); //스트링을 정수로 변환함.
		my[0] = temp / 100;// 백자리를 받는다.
		my[1] = (temp % 100) / 10;// 십자리를 받는다. 78/10 ->7
		my[2] = temp % 10;// 578을 10으로 나눈 나머지. 
	}

	public static void main(String[] args) {//메인메소드
		UserInput ui = new UserInput();
		ui.inputValue("587"); // 문자열 578을 정수로 바꿔주는 과정.
		for (int i = 0; i < ui.my.length; i++) {
			System.out.println(ui.my[i]);
		}
	}
}
