package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.delAccount.Secession;
import main.MainFrame;

public class PopSecession_Action implements ActionListener{
	
	public MainFrame m1 = null;
	public Secession s1 = null;
	
	public PopSecession_Action(MainFrame m1) {
		this.m1 = m1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		s1 = new Secession(m1.mem_id);
		s1.m1 = this.m1;
		
	}

}
