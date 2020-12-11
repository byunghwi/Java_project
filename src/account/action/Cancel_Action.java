package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.editAccount.Edit;

public class Cancel_Action implements ActionListener {
	
	Edit edit_info;
	
	public Cancel_Action(Edit edit_info) {
		this.edit_info = edit_info;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		edit_info.dispose();
	}

}
