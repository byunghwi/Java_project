package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.editAccount.Edit;
import account.editAccount.Edit_Account;

// 회원 정보 수정에 대응하는 액션 리스너
public class Edit_Action implements ActionListener  {
	
	Edit edit_info;
	Edit_Account ea;
	String [] edit_data = new String[8];
	
	public Edit_Action(Edit edit_info) {
		this.edit_info = edit_info;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 회원 정보 수정창의 비밀번호와 비밀번호 확인이 일치하는지 확인한다
		if (edit_info.infos[0].getText().equals(edit_info.infos[1].getText())) {
			// 만약 일치한다면 해당 비밀번호를 수정용 배열에 삽입한다
			edit_data[0] = edit_info.infos[0].getText();
		} else {
			// 일치하지 않는다면 null값을 삽입하여 회원정보가 수정되지 않도록 한다
			edit_data[0] = null;	
		}
		// 변경된 회원정보를 수정용 배열에 삽입한다
		edit_data[1] = edit_info.infos[2].getText();
		edit_data[2] = edit_info.res_infos[0].getText() + edit_info.res_infos[1].getText();
		edit_data[3] = edit_info.phone_infos[0].getText() + edit_info.phone_infos[1].getText() + edit_info.phone_infos[2].getText();
		edit_data[4] = edit_info.infos[3].getText();
		edit_data[5] = edit_info.rb1.isSelected() ? "M": "F";
		edit_data[6] = edit_info.infos[4].getText();
		edit_data[7] = edit_info.mem_id;
		
		// 삽입한 정보를 바탕으로 데이터를 수정한다
		ea = new Edit_Account(edit_data);
		
		// 수정에 성공했다면 회원정보 수정창을 닫는다
		if (ea.edit_suc)
			edit_info.dispose();
		
	}
	
	
	


}
