package account.action;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.Member;
import account.addAccount.Add_Account;
import account.addAccount.Join;

// ȸ�� ���� �׼� ������
public class Join_Action implements ActionListener {
	
	Join new_join;
	public String [] new_join_data = new String[8];
	Member new_mem = null;
	
	public Join_Action(Join new_join) {
		this.new_join = new_join;
	}
	
	// �Է�â���� �Է¹��� ������ ���� �� MemberŬ������ ���� �� DB�� ����
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<new_join_data.length; i++) {
			if (i == 6) {
				if(new_join.rb1.isSelected())
					new_join_data[i] = "M";
				else
					new_join_data[i] = "F";
				continue;
			}
			new_join_data[i] = new_join.infos[i].getText();
			
		}
	 	
		new_mem = new Member(
				new_join_data[0],
				new_join_data[1],
				new_join_data[2],
				new_join_data[3],
				new_join_data[4],
				new_join_data[5],
				new_join_data[6].charAt(0),
				new_join_data[7]
		);
		
		new Add_Account(this.new_mem);
		
	}
	
}
