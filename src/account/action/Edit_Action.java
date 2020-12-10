package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.editAccount.Edit;
import account.editAccount.Edit_Account;

public class Edit_Action implements ActionListener  {
	
	Edit edit_info;
	Edit_Account ea;
	String [] edit_data = new String[8];
	
	public Edit_Action(Edit edit_info) {
		this.edit_info = edit_info;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (edit_info.infos[0].getText().equals(edit_info.infos[1].getText())) {
			edit_data[0] = edit_info.infos[0].getText();
		} else {
			edit_data[0] = null;	
		}
		
		edit_data[1] = edit_info.infos[2].getText();
		edit_data[2] = edit_info.res_infos[0].getText() + edit_info.res_infos[1].getText();
		edit_data[3] = edit_info.phone_infos[0].getText() + edit_info.phone_infos[1].getText() + edit_info.phone_infos[2].getText();
		edit_data[4] = edit_info.infos[3].getText();
		edit_data[5] = edit_info.rb1.isSelected() ? "M": "F";
		edit_data[6] = edit_info.infos[4].getText();
		edit_data[7] = edit_info.mem_id;
		
		ea = new Edit_Account(edit_data);
		
		if (ea.edit_suc)
			edit_info.dispose();
		
	}
	
	
	


}
