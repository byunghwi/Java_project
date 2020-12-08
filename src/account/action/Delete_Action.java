package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.delAccount.Check_PW;
import account.delAccount.Del_Account;
import account.delAccount.Secession;

// 회원 탈퇴 액션 리스너
public class Delete_Action implements ActionListener {
	
	
	Secession info;
	
	// 받아온 정보가 저장될 배열
	public String [] info_data = new String[2];
	
	// 삭제 가능 여부를 파악할 변수
	boolean check_can_del = false;
	
	
	public Delete_Action(Secession info) {
		// Secession 클래스를 받아옴
		this.info = info;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 받아온 Secession 클래스의 id pw 정보를 배열로 저장
		for (int i=0; i<info_data.length; i++) {
			info_data[i] = info.infos[i].getText();
		}
		
		// 받아온 ID와 PW를 Check_PW로 검증(delAccount 패키지에 존재하는 클래스)
		Check_PW cp = new Check_PW(info_data[0],info_data[1]);
		
		// 회원 ID와 PW가 일치한다면 작동
		if (cp.check) {
			new Del_Account(info_data[0]);
			System.out.println("탈퇴 완료!!!!");
		}
		
	}

}


