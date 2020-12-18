package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.findAccount.FindSelectFrame;

public class Find_Action implements ActionListener  {
	
	public Find_Action() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new FindSelectFrame();
		
	}

}
