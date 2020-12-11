package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import account.Login;
import account.delAccount.Check_PW;
import account.fr.MainFrame;



// 占싸깍옙占쏙옙 占쌓쇽옙 占쏙옙占쏙옙占쏙옙
public class Login_Action extends JFrame implements ActionListener {
	
	Login info;
	public String [] info_data = new String[2];
	
	public Login_Action(Login info) {
		this.info = info;
	}

	
	// 占쏙옙占싱듸옙占� 占쏙옙橘占싫ｏ옙占� 占승다몌옙 占싸깍옙占쏙옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占싯억옙
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<info_data.length; i++) {
			info_data[i] = info.infos[i].getText();
		}
		
		Check_PW cp = new Check_PW(info_data[0],info_data[1]);
		
		if (cp.check) {
			System.out.println("占싸깍옙占쏙옙 占쏙옙占쏙옙!!!!");
			info.dispose();
			
			new MainFrame();
			
		}
		
	}

}
