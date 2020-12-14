package account.action;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.Member;
import account.addAccount.Add_Account;
import account.addAccount.Join;

// 회원 가입에 대응하는 액션 리스너
public class Join_Action implements ActionListener {
	
	Join new_join;
	public String [] new_join_data = new String[8];
	Member new_mem = null;
	
	public Join_Action(Join new_join) {
		this.new_join = new_join;
	}
	
	
	// 받아온 회원정보 데이터를 회원가입용 배열에 삽입한다
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<new_join_data.length; i++) {
			
			if (i == 3) {
				new_join_data[i] = new_join.res_infos[0].getText() + new_join.res_infos[1].getText();
				continue;
			}
			if (i == 4) {
				new_join_data[i] = new_join.phone_infos[0].getText() + new_join.phone_infos[1].getText() + new_join.phone_infos[2].getText();
				continue;
			}
			
			if (i == 6) {
				if(new_join.rb1.isSelected())
					new_join_data[i] = "M";
				else
					new_join_data[i] = "F";
				continue;
			}
			new_join_data[i] = new_join.infos[i].getText();
			
		}
		
	 	// 회원가입용 배열의 정보를 토대로 새 맴버 객채를 생성
		new_mem = new Member(
				new_join_data[0],
				new_join_data[1],
				new_join_data[2],
				new_join_data[3],
				new_join_data[4],
				new_join_data[5],
				new_join_data[6],
				new_join_data[7]
		);
		
		// 맴버 객채를 사용해 회원을 생성한다
		new Add_Account(this.new_mem);
		
	}
	
}
