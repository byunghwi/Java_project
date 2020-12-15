package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.addAccount.Join;

public class PopJoin_Action implements ActionListener {
	
	
	public PopJoin_Action() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new Join();
		
	}

}
