package disposal_alert;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AlertFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public JPanel dis_panel;
	public AlertView av = new AlertView();
	
	public AlertFrame() {
		setLayout(null);
		dis_panel = new JPanel();
		dis_panel.setBounds(0, 0, 100, 100);		
		dis_panel.add(av);		
		JOptionPane.showMessageDialog(null, dis_panel, "다음 상품들의 폐기기간을 확인해주세요", JOptionPane.INFORMATION_MESSAGE);
	}
	
}