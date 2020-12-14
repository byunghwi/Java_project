package stocksub.stockframe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import product.HintTextField;
import product.ProdRegistFrame;

public class RightBtnPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton productMoreInfoBtn;
	public JButton disposalInfoBtn;

	public RightBtnPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		productMoreInfoBtn = new JButton("상품정보");
		

		productMoreInfoBtn.setForeground(Color.WHITE);
		productMoreInfoBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		productMoreInfoBtn.setBackground(new Color(204, 206, 206));
		productMoreInfoBtn.setBounds(0, 0, 164, 120);
		
		add(productMoreInfoBtn);
		
		disposalInfoBtn = new JButton("폐기정보");
		disposalInfoBtn.setForeground(Color.WHITE);
		disposalInfoBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		disposalInfoBtn.setBackground(new Color(204, 206, 206));
		disposalInfoBtn.setBounds(0, 120, 164, 120);
		
		add(disposalInfoBtn);
		
		
	}

}