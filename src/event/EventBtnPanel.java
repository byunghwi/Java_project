package event;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

import common.RoundedButton;
import java.awt.SystemColor;
import javax.swing.UIManager;


public class EventBtnPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton eventRegBtn;
	public JButton eventDelBtn;

	public EventBtnPanel() {
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);
		eventRegBtn = new RoundedButton("이벤트등록");
		eventDelBtn = new RoundedButton("이벤트삭제");

		eventRegBtn.setForeground(Color.WHITE);
		eventRegBtn.setFont(new Font("나눔고딕", Font.BOLD, 20));
		eventRegBtn.setBackground(new Color(204, 206, 206));
		eventRegBtn.setBounds(0, 10, 140, 120);
		
		eventDelBtn.setForeground(Color.WHITE);
		eventDelBtn.setFont(new Font("나눔고딕", Font.BOLD, 20));
		eventDelBtn.setBackground(new Color(204, 206, 206));
		eventDelBtn.setBounds(0, 150, 140, 120);
		
		add(eventRegBtn);
		add(eventDelBtn);
	}
	
	public void selectedBtn(JButton selectedBtn) {
		for (int i = 0; i < getComponentCount(); i++) {
			getComponent(i).setBackground(new Color(204, 206, 206));
		}
		selectedBtn.setBackground(new Color(0,10,10));
	}

}