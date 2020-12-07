import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RightBtnPanel extends JPanel{
	public JButton registProdBtn;
	public JButton delProdBtn;

	public RightBtnPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		registProdBtn = new JButton("상품등록");
		delProdBtn = new JButton("상품삭제");
		registProdBtn.setBounds(0, 0, 164, 120);
		delProdBtn.setBounds(0, 120, 164, 120);
		add(registProdBtn);
		add(delProdBtn);
		
		registProdBtn.setForeground(Color.WHITE);
		registProdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		registProdBtn.setBackground(new Color(204, 204, 204));
		
		delProdBtn.setForeground(Color.WHITE);
		delProdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		delProdBtn.setBackground(new Color(153, 153, 153));
	}
}
