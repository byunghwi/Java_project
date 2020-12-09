package account.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import account.delAccount.Check_PW;
import account.delAccount.Del_Account;
import account.delAccount.Secession;

// ȸ�� Ż�� �׼� ������
public class Delete_Action implements ActionListener {
	
	
	Secession info;
	
	// �޾ƿ� ������ ����� �迭
	public String [] info_data = new String[2];
	
	// ���� ���� ���θ� �ľ��� ����
	boolean check_can_del = false;
	
	
	public Delete_Action(Secession info) {
		// Secession Ŭ������ �޾ƿ�
		this.info = info;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// �޾ƿ� Secession Ŭ������ id pw ������ �迭�� ����
		for (int i=0; i<info_data.length; i++) {
			info_data[i] = info.infos[i].getText();
		}
		
		// �޾ƿ� ID�� PW�� Check_PW�� ����(delAccount ��Ű���� �����ϴ� Ŭ����)
		Check_PW cp = new Check_PW(info_data[0],info_data[1]);
		
		// ȸ�� ID�� PW�� ��ġ�Ѵٸ� �۵�
		if (cp.check) {
			new Del_Account(info_data[0]);
			System.out.println("Ż�� �Ϸ�!!!!");
		}
		
	}

}


