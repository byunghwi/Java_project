package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import main.Login;
import main.MainFrame;
import account.delAccount.Check_PW;



// 로그인에 대응하는 액션 리스너
public class Login_Action extends JFrame implements ActionListener {
	
	Login info;
	public String [] info_data = new String[2];
	MainFrame m1 = null;
	
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
			
			m1 = new MainFrame();
			// 메인 프레임에 로그인한 ID정보를 삽입
			m1.mem_id = info_data[0];
			
			System.out.println("로그인 성공!!!!");
			info.dispose();
			
			
			
			
			
		}
		
	}

}
