package calc.MainCalcFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import common.RoundedButton;

public class CalcBtnPanel extends JPanel{

	private final long serialVersionUID = 1L;
	public JButton calc_Btn;
	public JButton calc_GraphBtn;
	
	public CalcBtnPanel() {
	
		setLayout(null);
		calc_Btn = new RoundedButton("정산");
		
		calc_Btn.setForeground(Color.WHITE);
		calc_Btn.setFont(new Font("나눔 고딕", Font.BOLD, 20));
		calc_Btn.setBackground(new Color(204, 206, 206));
		calc_Btn.setBounds(0, 10, 140, 120);

		add(calc_Btn);
	
	}
	
	public void selectedBtn(JButton selectedBtn) {
		for (int i = 0; i < getComponentCount(); i++) {
			getComponent(i).setBackground(new Color(204, 206, 206));
		}
		selectedBtn.setBackground(new Color(0,10,10));
	}
	
}
