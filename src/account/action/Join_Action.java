package account.action;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.Add_Account;
import account.Insert_info;
import account.Member;


public class Join_Action implements ActionListener {
	
	Insert_info new_info;
	public String [] new_info_data = new String[8];
	Member new_mem = null;
	
	public Join_Action(Insert_info new_info) {
		this.new_info = new_info;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<new_info_data.length; i++) {
			new_info_data[i] = new_info.infos[i].getText();
		}
	 	
		new_mem = new Member(
				new_info_data[0],
				new_info_data[1],
				new_info_data[2],
				new_info_data[3],
				new_info_data[4],
				new_info_data[5],
				new_info_data[6].charAt(0),
				new_info_data[7]
		);
		
		new Add_Account(this.new_mem);
		
	}

	
	
	
	
}
