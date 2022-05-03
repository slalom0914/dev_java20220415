package levelup.quiz;

public class TRandomGameLogic {
	TRandomGameView rgView = null;
	public TRandomGameLogic(TRandomGameView rgView) {
		this.rgView = rgView;
	}
	public void newGame()
	{
		rgView.ta_result.append("새로운 게임을 시작합니다."+"\n");
		rgView.count = 1;
		rgView.com = (int)(Math.random()*10);
	}
	public void gameTest(int user)
	{
		//while(!isFlag){
			if(user==rgView.com){
				rgView.hint = "축하합니다.";
				rgView.ta_result.append(rgView.count++ +". 입력한 값은 "+user+" : "+rgView.hint+"\n");
				//dispose();
				//newGame();
				rgView.isFlag = true;
			}else if(user > rgView.com){
				rgView.hint = "나차라~~";
				rgView.ta_result.append(rgView.count++ +". 입력한 값은 "+user+" : "+rgView.hint+"\n");
				rgView.ta_result.setCaretPosition(rgView.ta_result.getDocument().getLength());
				if(rgView.count == 6){
					rgView.ta_result.append("넌 바보"+"\n");
					newGame();
				}
				rgView.isFlag = true;
					//count = 1;
			}else if(user < rgView.com){
				rgView.hint = "노피라~~";
				rgView.ta_result.append(rgView.count++ +". 입력한 값은 "+user+" : "+rgView.hint+"\n");
				rgView.ta_result.setCaretPosition(rgView.ta_result.getDocument().getLength());
				if(rgView.count == 6){
					rgView.ta_result.append("넌 바보"+"\n");
					newGame();
				}	
				rgView.isFlag = true;
					//count = 1;
			}
		//}
	}
}
