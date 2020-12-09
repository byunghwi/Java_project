package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.editAccount.Edit_Account;

public class Edit_Action implements ActionListener  {
	
	Edit_Account edit_info;
	
	public Edit_Action(Edit_Account edit_info) {
		this.edit_info = edit_info;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("√Îº“")) {
			edit_info.dispose();
		}
		else {
			
		}
		
	}

}
