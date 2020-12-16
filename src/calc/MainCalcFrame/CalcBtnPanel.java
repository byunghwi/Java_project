package calc.MainCalcFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CalcBtnPanel extends JPanel{

	private final long serialVersionUID = 1L;
	public JButton calc_Btn;
	public JButton calc_GraphBtn;
	
	public CalcBtnPanel() {
	
		setLayout(null);
		calc_Btn = new JButton("정산");
		
		calc_Btn.setForeground(Color.WHITE);
		calc_Btn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		calc_Btn.setBackground(new Color(204, 206, 206));
		calc_Btn.setBounds(0, 0, 124, 120);
		

		
		add(calc_Btn);
	
		
	}
	
}
