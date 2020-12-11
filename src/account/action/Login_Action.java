package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import account.Login;
import account.delAccount.Check_PW;
import stocksub.stockframe.MainFrame;



// 로그인 액션 리스너
public class Login_Action extends JFrame implements ActionListener {
	
	Login info;
	public String [] info_data = new String[2];
	
	public Login_Action(Login info) {
		this.info = info;
	}

	
	// 로그인 버튼의 동작
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<info_data.length; i++) {
			info_data[i] = info.infos[i].getText();
		}
		
		Check_PW cp = new Check_PW(info_data[0],info_data[1]);
		
		if (cp.check) {
			System.out.println("로그인 성공!!!!");
			info.dispose();
			
			new MainFrame();
			
		}
		
	}

}
