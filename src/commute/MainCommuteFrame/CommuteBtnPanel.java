package commute.MainCommuteFrame;

import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.RoundedButton;


public class CommuteBtnPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton on_timeBtn;
	public JButton off_timeBtn;
	public JButton commuteBtn;

	public CommuteBtnPanel() {
		
		setLayout(null);
		
		
		
		
		on_timeBtn = new RoundedButton("출근");
		off_timeBtn = new RoundedButton("퇴근");
		commuteBtn = new RoundedButton("근태목록");

		on_timeBtn.setFont(new Font("나눔고딕", Font.BOLD, 20));
		on_timeBtn.setBounds(0, 10, 140, 120);
		
	
		off_timeBtn.setFont(new Font("나눔고딕", Font.BOLD, 20));
		off_timeBtn.setBounds(0, 150, 140, 120);
		
	
		commuteBtn.setFont(new Font("나눔고딕", Font.BOLD, 20));
		commuteBtn.setBounds(0, 300, 140, 120);

		add(on_timeBtn);
		add(off_timeBtn);
		add(commuteBtn);
	}
	public void selectedBtn(JButton selectedBtn) {
		for (int i = 0; i < getComponentCount(); i++) {
			getComponent(i).setBackground(new Color(204, 206, 206));
		}
		selectedBtn.setBackground(new Color(0,10,10));
	}

}
