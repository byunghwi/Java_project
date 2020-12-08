package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.Login;
import account.delAccount.Check_PW;
import product.ProductView;


public class Login_Action implements ActionListener {
	
	Login info;
	public String [] info_data = new String[2];
	boolean check_can_del = false;
	
	public Login_Action(Login info) {
		this.info = info;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<info_data.length; i++) {
			info_data[i] = info.infos[i].getText();
		}
		
		Check_PW cp = new Check_PW(info_data[0],info_data[1]);
		
		if (cp.check) {
			System.out.println("로그인 성공!!!!");
			
		}
		
	}

}
