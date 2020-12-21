package product;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

import common.RoundedButton;
import java.awt.SystemColor;


public class ProdBtnPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton registProdBtn;
	public JButton editProdBtn;
	public JButton delProdBtn;

	public ProdBtnPanel() {
		setBackground(SystemColor.control);
		setLayout(null);
		registProdBtn = new RoundedButton("상품등록");
		editProdBtn = new RoundedButton("상품수정");
		delProdBtn = new RoundedButton("상품삭제");

		//registProdBtn.setForeground(Color.WHITE);
		registProdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		//registProdBtn.setBackground(new Color(204, 206, 206));
		registProdBtn.setBounds(0, 0, 140, 120);
		
		//editProdBtn.setForeground(Color.WHITE);
		editProdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		//editProdBtn.setBackground(new Color(204, 206, 206));
		editProdBtn.setBounds(0, 150, 140, 120);
		
		//delProdBtn.setForeground(Color.WHITE);
		delProdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		//delProdBtn.setBackground(new Color(204, 206, 206));
		delProdBtn.setBounds(0, 300, 140, 120);

		add(registProdBtn);
		add(editProdBtn);
		add(delProdBtn);

	}
	
	public void selectedBtn(JButton selectedBtn) {
		for (int i = 0; i < getComponentCount(); i++) {
			getComponent(i).setBackground(new Color(204, 206, 206));
		}
		selectedBtn.setBackground(new Color(0,10,10));
	}

}