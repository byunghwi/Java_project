package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import account.findAccount.FindIdFrame;

public class Find_Id_Action implements ActionListener {
	
	JFrame j1 = null;

	public Find_Id_Action(JFrame j1) {
		this.j1 = j1;
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		new FindIdFrame();
		j1.dispose();
	}

}
