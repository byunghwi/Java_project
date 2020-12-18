package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.editAccount.Edit;
import main.MainFrame;

public class UserInfoAction implements ActionListener {
	
	MainFrame m1;
	
	public UserInfoAction(MainFrame m1) {
		this.m1 = m1;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new Edit(m1.mem_id);
		
	}
	
}
