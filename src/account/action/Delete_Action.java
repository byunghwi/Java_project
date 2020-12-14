package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.delAccount.Check_PW;
import account.delAccount.Del_Account;
import account.delAccount.Secession;

// 회원 탈퇴에 대응하는 액션 리스너
public class Delete_Action implements ActionListener {
	
	Secession info;
	
	public String [] info_data = new String[2];
	
	public Delete_Action(Secession info) {
		
		this.info = info;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		for (int i=0; i<info_data.length; i++) {
			info_data[i] = info.infos[i].getText();
		}
		
		// 입력받은 회원정보의 아이디와 비밀번호가 일치하는지를 확인한다
		Check_PW cp = new Check_PW(info_data[0],info_data[1]);
		
		// 만약 일치한다면 탈퇴를 진행한다
		if (cp.check) {
			new Del_Account(info_data[0]);
			System.out.println("탈퇴 성공!!!!");
		}
		
	}

}


