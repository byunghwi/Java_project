package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import account.Login;
import account.delAccount.Check_PW;
import stocksub.stockframe.StockFrame;



// 로그인에 대응하는 액션 리스너
public class Login_Action extends JFrame implements ActionListener {
	
	Login info;
	public String [] info_data = new String[2];
	
	public Login_Action(Login info) {
		this.info = info;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<info_data.length; i++) {
			info_data[i] = info.infos[i].getText();
		}
		
		Check_PW cp = new Check_PW(info_data[0],info_data[1]);
		
		// 받은 ID와 대응하는 PW정보가 일치한다면 프레임 창을 생성한다
		if (cp.check) {
			System.out.println("로그인 성공!!!!");
			info.dispose();
			
			new StockFrame();
			
			
		}
		
	}

}
