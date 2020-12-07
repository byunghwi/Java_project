package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.Check_PW;
import account.Del_Account;
import account.Delete_info;

public class Delete_Action implements ActionListener {
	
	Delete_info info;
	public String [] info_data = new String[2];
	boolean check_can_del = false;
	
	public Delete_Action(Delete_info info) {
		this.info = info;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<info_data.length; i++) {
			info_data[i] = info.infos[i].getText();
		}
		
		Check_PW cp = new Check_PW(info_data[0],info_data[1]);
		
		if (cp.check) {
			new Del_Account(info_data[0]);
			System.out.println("삭제 완료!!!!");
		}
		
	}

}
