package levelup.quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TRandomGameEvent implements ActionListener {
	TRandomGameView rgView = null;
	public TRandomGameEvent(TRandomGameView rgView) {
		this.rgView = rgView;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
			
		if(obj==rgView.btn_zero){
			rgView.logic.gameTest(Integer.parseInt(rgView.btn_zero.getText()));
		}
		else if(obj==rgView.btn_one){
			rgView.logic.gameTest(Integer.parseInt(rgView.btn_one.getText()));
		}
		else if(obj==rgView.btn_two){
			rgView.logic.gameTest(Integer.parseInt(rgView.btn_two.getText()));
		}
		else if(obj==rgView.btn_three){
			rgView.logic.gameTest(Integer.parseInt(rgView.btn_three.getText()));
		}
		else if(obj==rgView.btn_four){
			rgView.logic.gameTest(Integer.parseInt(rgView.btn_four.getText()));
		}
		else if(obj==rgView.btn_five){
			rgView.logic.gameTest(Integer.parseInt(rgView.btn_five.getText()));
		}
		else if(obj==rgView.btn_six){
			rgView.logic.gameTest(Integer.parseInt(rgView.btn_six.getText()));
		}
		else if(obj==rgView.btn_seven){
			rgView.logic.gameTest(Integer.parseInt(rgView.btn_seven.getText()));
		}
		else if(obj==rgView.btn_eight){
			rgView.logic.gameTest(Integer.parseInt(rgView.btn_eight.getText()));
		}
		else if(obj==rgView.btn_nine){
			rgView.logic.gameTest(Integer.parseInt(rgView.btn_nine.getText()));
		}
		else if(obj == rgView.btn_newGame){
			rgView.logic.newGame();
		}
		else if(obj == rgView.btn_exit){
			System.exit(0);
		}
	}
}
