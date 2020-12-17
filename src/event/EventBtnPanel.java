package event;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;


public class EventBtnPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton eventRegBtn;
	public JButton eventDelBtn;

	public EventBtnPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		eventRegBtn = new JButton("이벤트등록");
		eventDelBtn = new JButton("이벤트삭제");

		eventRegBtn.setForeground(Color.WHITE);
		eventRegBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		eventRegBtn.setBackground(new Color(204, 206, 206));
		eventRegBtn.setBounds(0, 0, 140, 120);
		
		eventDelBtn.setForeground(Color.WHITE);
		eventDelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		eventDelBtn.setBackground(new Color(204, 206, 206));
		eventDelBtn.setBounds(0, 120, 140, 120);
		
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