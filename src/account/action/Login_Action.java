package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import account.Login;
import account.delAccount.Check_PW;
import account.fr.MainFrame;



// 로그인 액션 리스너
public class Login_Action extends JFrame implements ActionListener {
	
	Login info;
	public String [] info_data = new String[2];
	
	public Login_Action(Login info) {
		this.info = info;
	}

	
	// 아이디와 비밀번호가 맞다면 로그인 성공 후 메인 프레임 팝업
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
