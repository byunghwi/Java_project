import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RightBtnPanel extends JPanel{
	public JButton stockSearch;
	
	public RightBtnPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		stockSearch = new JButton("\uC7AC\uACE0\uC870\uD68C");
		stockSearch.setBounds(0, 0, 164, 120);
		add(stockSearch);
		stockSearch.setForeground(Color.WHITE);
		stockSearch.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		stockSearch.setBackground(new Color(0, 0, 128));
	}
}
