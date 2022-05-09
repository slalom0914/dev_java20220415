package baseball;

public class Baseball_App {

	public static void main(String[] args) {
		Baseball_game2 start = new Baseball_game2();
		while (true) {
			try {
				start.account();
			} catch (Exception e) {
				System.out.println("숫자만 3개 입력해 주세요");
			}
		}
	}

}